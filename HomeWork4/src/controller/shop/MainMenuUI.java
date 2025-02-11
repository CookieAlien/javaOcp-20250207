package controller.shop;

import java.awt.EventQueue;
import java.awt.Font;
import java.nio.file.spi.FileTypeDetector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.ShopMember;
import util.ClockPanel;
import util.FileTool;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ShopMember shopMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuUI frame = new MainMenuUI();
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
	public MainMenuUI() {
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		shopMember = (ShopMember) FileTool.load("ShopMember.txt");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 466, 81);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("普龍共");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel.setBounds(10, 10, 188, 33);
		titlePanel.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("電視遊樂器專賣店");
		subtitleLabel.setForeground(new Color(255, 255, 255));
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		subtitleLabel.setBounds(10, 45, 188, 21);
		titlePanel.add(subtitleLabel);
		
		ClockPanel clockPanel = new ClockPanel();
		clockPanel.setBackground(new Color(32, 175, 234));
		clockPanel.setBounds(248, 12, 208, 54);
		titlePanel.add(clockPanel);
		
		JLabel welcomeLabel = new JLabel("歡迎，");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(new Color(0, 0, 0));
		welcomeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		welcomeLabel.setBounds(53, 101, 377, 33);
		contentPane.add(welcomeLabel);
		
		welcomeLabel.setText("歡迎，"+shopMember.getName());
		
		JButton addOrderButton = new JButton("新增訂單");
		addOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddOrderUI().setVisible(true);
				dispose();
			}
		});
		addOrderButton.setBackground(new Color(255, 255, 255));
		addOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		addOrderButton.setBounds(28, 201, 119, 39);
		contentPane.add(addOrderButton);
		
		JButton viewOrderButton = new JButton("查詢訂單");
		viewOrderButton.setBackground(new Color(255, 255, 255));
		viewOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		viewOrderButton.setBounds(182, 201, 119, 39);
		contentPane.add(viewOrderButton);
		
		JButton manageButton = new JButton("訂單管理");
		manageButton.setEnabled(shopMember.getRole().equals("staff"));
		manageButton.setBackground(new Color(255, 255, 255));
		manageButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		manageButton.setBounds(340, 201, 119, 39);
		contentPane.add(manageButton);
		
		JLabel lblNewLabel = new JLabel("(員工專用)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(340, 176, 119, 23);
		contentPane.add(lblNewLabel);
		
		JButton exitButton = new JButton("離開");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setForeground(new Color(255, 255, 255));
		exitButton.setBackground(new Color(255, 0, 0));
		exitButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		exitButton.setBounds(182, 283, 119, 39);
		contentPane.add(exitButton);
		
		JButton updateInfoButton = new JButton("修改個人資訊");
		updateInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeInfoUI().setVisible(true);
				dispose();
			}
		});
		updateInfoButton.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		updateInfoButton.setBackground(Color.WHITE);
		updateInfoButton.setBounds(28, 283, 132, 39);
		contentPane.add(updateInfoButton);
		
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
}
