package controller.shop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.ShopMember;
import model.ShopOrder;
import service.impl.ShopOrderServiceImpl;
import util.ClockPanel;
import util.FileTool;

public class ViewOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea outputArea;
	private ShopMember member;
	private static ShopOrderServiceImpl shopOrderServiceImpl = new ShopOrderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrderUI frame = new ViewOrderUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewOrderUI() {
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//讀取當前使用者資料
		member = (ShopMember) FileTool.load("ShopMember.txt");
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 466, 81);
		contentPane.add(titlePanel);
		
		JLabel titleLabel = new JLabel("普龍共");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel.setBounds(10, 10, 188, 33);
		titlePanel.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("電視遊樂器專賣店");
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		subtitleLabel.setBounds(10, 45, 188, 21);
		titlePanel.add(subtitleLabel);
		
		ClockPanel clockPanel = new ClockPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) clockPanel.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[]{0};
		clockPanel.setBackground(new Color(32, 175, 234));
		clockPanel.setBounds(248, 12, 208, 54);
		titlePanel.add(clockPanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(32, 175, 234));
		mainPanel.setBounds(10, 101, 466, 257);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel titleLabel_1 = new JLabel("我的訂單");
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setForeground(Color.WHITE);
		titleLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel_1.setBounds(10, 10, 150, 33);
		mainPanel.add(titleLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 446, 194);
		mainPanel.add(scrollPane);
		
		outputArea = new JTextArea();
		outputArea.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		scrollPane.setViewportView(outputArea);
		
		JButton refreshButton = new JButton("重新整理");
		refreshButton.setBackground(new Color(255, 255, 255));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMyOrders();
			}
		});
		refreshButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		refreshButton.setBounds(295, 10, 108, 35);
		mainPanel.add(refreshButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.setBackground(new Color(255, 255, 255));
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI().setVisible(true);
				dispose();
			}
		});
		returnButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		returnButton.setBounds(189, 368, 96, 35);
		contentPane.add(returnButton);
		
		getMyOrders();
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	
	private void getMyOrders() {
		List<ShopOrder> myOrders = shopOrderServiceImpl.getOrdersByName(member.getUsername());
		StringBuilder s = new StringBuilder();
		for (ShopOrder shopOrder : myOrders) {
			s.append("訂單ID:").append(shopOrder.getId());
			if (shopOrder.getPs5pro()>0) {
				s.append("  PS5 PRO:").append(shopOrder.getPs5pro()).append("台");
			}
			if (shopOrder.getPs5slim()>0) {
				s.append("  PS5 Slim:").append(shopOrder.getPs5slim()).append("台");
			}
			if (shopOrder.getNswitch()>0) {
				s.append("  Nintendo Switch:").append(shopOrder.getNswitch()).append("台");
			}
			if (shopOrder.getSteamdeck()>0) {
				s.append("  Steam Deck:").append(shopOrder.getSteamdeck()).append("台");
			}
			if (shopOrder.getXboxcontroller()>0) {
				s.append("  XBOX 無線手把:").append(shopOrder.getXboxcontroller()).append("支");
			}
			s.append("  更新時間:").append(shopOrder.getLastModified())
			 .append("\n");
		}
		outputArea.setText(s.toString());
	}
}
