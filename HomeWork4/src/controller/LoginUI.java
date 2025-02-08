package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ClockPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 175, 234));
		panel.setBounds(10, 10, 466, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("普龍共");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel.setBounds(10, 10, 188, 33);
		panel.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("電視遊樂器專賣店");
		subtitleLabel.setForeground(new Color(255, 255, 255));
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		subtitleLabel.setBounds(10, 45, 188, 21);
		panel.add(subtitleLabel);
		
		ClockPanel clockPanel = new ClockPanel();
		clockPanel.setBackground(new Color(32, 175, 234));
		clockPanel.setBounds(248, 12, 208, 54);
		panel.add(clockPanel);
		
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
		usernameField.setBounds(158, 61, 141, 29);
		mainPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("密碼：");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		passwordLabel.setBounds(30, 122, 118, 28);
		mainPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 122, 141, 28);
		mainPanel.add(passwordField);
		
		JButton loginButton = new JButton("登入");
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
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
}
