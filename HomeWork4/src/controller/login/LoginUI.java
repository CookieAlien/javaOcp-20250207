package controller.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.shop.MainMenuUI;
import model.ShopMember;
import service.impl.ShopMemberServiceImpl;
import util.ClockPanel;
import util.DBConnection;
import util.FileTool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private static ShopMemberServiceImpl shopMemberServiceImpl = new ShopMemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 466, 76);
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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 96, 466, 257);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 10, 141, 28);
		mainPanel.add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("帳號：");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		usernameLabel.setBounds(30, 61, 118, 28);
		mainPanel.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		usernameField.setBounds(158, 61, 141, 29);
		mainPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("密碼：");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		passwordLabel.setBounds(30, 122, 118, 28);
		mainPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		passwordField.setBounds(158, 122, 141, 28);
		mainPanel.add(passwordField);
		
		JButton loginButton = new JButton("登入");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				ShopMember member = shopMemberServiceImpl.login(username, password);
				if (member!=null) {
					FileTool.save(member, "ShopMember.txt");
					new MainMenuUI().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "帳號或密碼錯誤!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(234, 0, 0));
		loginButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		loginButton.setBounds(176, 181, 103, 35);
		mainPanel.add(loginButton);
		
		JButton registerButton = new JButton("註冊");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterUI().setVisible(true);
				dispose();
			}
		});
		registerButton.setForeground(Color.WHITE);
		registerButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		registerButton.setBackground(new Color(0, 225, 0));
		registerButton.setBounds(327, 181, 103, 35);
		mainPanel.add(registerButton);
		

		Connection connection = DBConnection.getConnection();
		if (connection==null) {
			JOptionPane.showMessageDialog(contentPane, "未連結至資料庫!", "錯誤", JOptionPane.ERROR_MESSAGE);
		}
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
}
