package controller.shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ShopOrder;
import service.impl.ShopMemberServiceImpl;
import service.impl.ShopOrderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import util.ClockPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField viewIDField;
	private JTextField viewUsernameField;
	private JTextField delIDField;
	private JTextField updateIDField;
	private JTextArea outputArea;
	private static ShopOrderServiceImpl shopOrderServiceImpl = new ShopOrderServiceImpl();
	private static ShopMemberServiceImpl shopMemberServiceImpl = new ShopMemberServiceImpl();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI frame = new ManagerUI();
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
	public ManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(0, 0, 1176, 81);
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
		clockPanel.setBounds(958, 12, 208, 54);
		titlePanel.add(clockPanel);
		
		JLabel managerLabel = new JLabel("操作員：admin");
		managerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		managerLabel.setForeground(Color.WHITE);
		managerLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		managerLabel.setBounds(458, 22, 267, 33);
		titlePanel.add(managerLabel);
		
		JButton exitButton = new JButton("離開");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI().setVisible(true);
				dispose();
			}
		});
		exitButton.setMargin(new Insets(1, 1, 1, 1));
		exitButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.setBounds(771, 22, 100, 36);
		titlePanel.add(exitButton);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(new Color(32, 175, 234));
		orderPanel.setBounds(10, 92, 624, 386);
		contentPane.add(orderPanel);
		orderPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 584, 307);
		orderPanel.add(scrollPane);
		
		outputArea = new JTextArea();
		outputArea.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		scrollPane.setViewportView(outputArea);
		
		JButton viewAllButton = new JButton("查詢全部");
		viewAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAllOrders();
			}
		});
		viewAllButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		viewAllButton.setBackground(new Color(255, 255, 255));
		viewAllButton.setBounds(10, 20, 98, 36);
		orderPanel.add(viewAllButton);
		
		JLabel viewIDLabel = new JLabel("ID:");
		viewIDLabel.setForeground(new Color(255, 255, 255));
		viewIDLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		viewIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		viewIDLabel.setBounds(118, 20, 35, 39);
		orderPanel.add(viewIDLabel);
		
		viewIDField = new JTextField();
		viewIDField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		viewIDField.setBounds(163, 25, 75, 29);
		orderPanel.add(viewIDField);
		viewIDField.setColumns(10);
		
		JButton btnid = new JButton("依ID查詢");
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(viewIDField.getText());
					viewOrdersByID(id);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "ID格式須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnid.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		btnid.setBackground(Color.WHITE);
		btnid.setBounds(248, 20, 91, 36);
		btnid.setMargin(new Insets(1, 1, 1, 1));
		orderPanel.add(btnid);
		
		JLabel viewAccLabel = new JLabel("帳號:");
		viewAccLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		viewAccLabel.setForeground(Color.WHITE);
		viewAccLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		viewAccLabel.setBounds(338, 20, 45, 39);
		orderPanel.add(viewAccLabel);
		
		viewUsernameField = new JTextField();
		viewUsernameField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		viewUsernameField.setColumns(10);
		viewUsernameField.setBounds(393, 25, 114, 29);
		orderPanel.add(viewUsernameField);
		
		JButton btnacc = new JButton("依帳號查詢");
		btnacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOrdersByUsername(viewUsernameField.getText());
			}
		});
		btnacc.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		btnacc.setBackground(Color.WHITE);
		btnacc.setBounds(517, 20, 97, 36);
		btnacc.setMargin(new Insets(1, 1, 1, 1));
		orderPanel.add(btnacc);
		
		JPanel updateOrderPanel = new JPanel();
		updateOrderPanel.setBackground(new Color(32, 175, 234));
		updateOrderPanel.setBounds(10, 488, 624, 184);
		contentPane.add(updateOrderPanel);
		updateOrderPanel.setLayout(null);
		
		JLabel updateIDLabel = new JLabel("ID:");
		updateIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		updateIDLabel.setForeground(Color.WHITE);
		updateIDLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		updateIDLabel.setBounds(97, 10, 35, 39);
		updateOrderPanel.add(updateIDLabel);
		
		updateIDField = new JTextField();
		updateIDField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		updateIDField.setColumns(10);
		updateIDField.setBounds(142, 15, 91, 29);
		updateOrderPanel.add(updateIDField);
		
		JButton getOrderButton = new JButton("查詢訂單");
		getOrderButton.setMargin(new Insets(1, 1, 1, 1));
		getOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		getOrderButton.setBackground(Color.WHITE);
		getOrderButton.setBounds(282, 13, 91, 36);
		updateOrderPanel.add(getOrderButton);
		
		JButton updateOrderButton = new JButton("更新訂單");
		updateOrderButton.setForeground(new Color(255, 255, 255));
		updateOrderButton.setMargin(new Insets(1, 1, 1, 1));
		updateOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		updateOrderButton.setBackground(new Color(0, 255, 0));
		updateOrderButton.setBounds(444, 13, 91, 36);
		updateOrderPanel.add(updateOrderButton);
		
		JLabel updateIDLabel_1 = new JLabel("更新");
		updateIDLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		updateIDLabel_1.setForeground(Color.WHITE);
		updateIDLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		updateIDLabel_1.setBounds(10, 10, 67, 39);
		updateOrderPanel.add(updateIDLabel_1);
		
		JLabel productLabel = new JLabel("PS5 PRO:");
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel.setForeground(Color.WHITE);
		productLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		productLabel.setBounds(20, 60, 96, 39);
		updateOrderPanel.add(productLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(126, 65, 60, 29);
		updateOrderPanel.add(textField);
		
		JLabel productLabel_1 = new JLabel("PS5 Slim:");
		productLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_1.setForeground(Color.WHITE);
		productLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		productLabel_1.setBounds(196, 59, 96, 39);
		updateOrderPanel.add(productLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(302, 65, 60, 29);
		updateOrderPanel.add(textField_1);
		
		JLabel productLabel_2 = new JLabel("Nintendo Switch:");
		productLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_2.setForeground(Color.WHITE);
		productLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		productLabel_2.setBounds(372, 60, 148, 39);
		updateOrderPanel.add(productLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(530, 65, 60, 29);
		updateOrderPanel.add(textField_2);
		
		JLabel lblSteamDeck_1 = new JLabel("Steam Deck:");
		lblSteamDeck_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSteamDeck_1.setForeground(Color.WHITE);
		lblSteamDeck_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblSteamDeck_1.setBounds(66, 109, 118, 39);
		updateOrderPanel.add(lblSteamDeck_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(194, 114, 60, 29);
		updateOrderPanel.add(textField_3);
		
		JLabel lblSteamDeck = new JLabel("XBOX 無線控制器:");
		lblSteamDeck.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSteamDeck.setForeground(Color.WHITE);
		lblSteamDeck.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblSteamDeck.setBounds(264, 109, 173, 39);
		updateOrderPanel.add(lblSteamDeck);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(447, 114, 60, 29);
		updateOrderPanel.add(textField_4);
		
		JPanel deleteOrderPanel = new JPanel();
		deleteOrderPanel.setBackground(new Color(32, 175, 234));
		deleteOrderPanel.setBounds(10, 682, 624, 71);
		contentPane.add(deleteOrderPanel);
		deleteOrderPanel.setLayout(null);
		
		JLabel delIDLabel = new JLabel("ID:");
		delIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		delIDLabel.setForeground(Color.WHITE);
		delIDLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		delIDLabel.setBounds(121, 20, 35, 39);
		deleteOrderPanel.add(delIDLabel);
		
		delIDField = new JTextField();
		delIDField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		delIDField.setColumns(10);
		delIDField.setBounds(166, 25, 91, 29);
		deleteOrderPanel.add(delIDField);
		
		JButton delOrderButton = new JButton("刪除訂單");
		delOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(delIDField.getText());
					int select = JOptionPane.showConfirmDialog(contentPane, "確定要刪除訂單ID:"+id+"?此動作無法復原!", "訊息", JOptionPane.YES_NO_OPTION);
					if (select == JOptionPane.YES_OPTION) {
						shopOrderServiceImpl.deleteOrder(id);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "ID格式須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		delOrderButton.setForeground(new Color(255, 255, 255));
		delOrderButton.setMargin(new Insets(1, 1, 1, 1));
		delOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		delOrderButton.setBackground(new Color(255, 0, 0));
		delOrderButton.setBounds(347, 20, 100, 38);
		deleteOrderPanel.add(delOrderButton);
		
		JLabel updateIDLabel_1_1 = new JLabel("刪除");
		updateIDLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		updateIDLabel_1_1.setForeground(Color.WHITE);
		updateIDLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		updateIDLabel_1_1.setBounds(10, 20, 67, 39);
		deleteOrderPanel.add(updateIDLabel_1_1);
	
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	
	private void viewOrders(List<ShopOrder> orders) {
		if (orders.size()==0) {
			JOptionPane.showMessageDialog(contentPane, "查無資訊!");
			return;
		}
		StringBuilder s = new StringBuilder();
		for (ShopOrder shopOrder : orders) {
			s.append("訂單ID:").append(shopOrder.getId());
			s.append("  帳號:").append(shopOrder.getUsername());
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
	
	private void viewAllOrders() {
		List<ShopOrder> allOrders = shopOrderServiceImpl.getAllOrders();
		viewOrders(allOrders);
	}
	private void viewOrdersByID(int id) {
		List<ShopOrder> orders = new ArrayList<ShopOrder>();
	 	ShopOrder o = shopOrderServiceImpl.getOrderById(id);
	 	if (o!=null) {
			orders.add(o);
		}
		viewOrders(orders);
	}
	private void viewOrdersByUsername(String username) {
		List<ShopOrder> orders = shopOrderServiceImpl.getOrdersByName(username);
		viewOrders(orders);
	}
}
