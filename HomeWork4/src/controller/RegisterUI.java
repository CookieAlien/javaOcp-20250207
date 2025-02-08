package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.ClockPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField emailField;
	private JTextField phoneField;
	private Border defaultBorder = new JTextField().getBorder();
	private Border errorBorder = new LineBorder(Color.red,2);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 175, 234));
		panel.setBounds(10, 10, 616, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("普龍共");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel.setBounds(99, 5, 72, 33);
		panel.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("電視遊樂器專賣店");
		subtitleLabel.setForeground(new Color(255, 255, 255));
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		subtitleLabel.setBounds(76, 48, 115, 20);
		panel.add(subtitleLabel);
		
		ClockPanel clockPanel = new ClockPanel();
		clockPanel.setBackground(new Color(32, 175, 234));
		clockPanel.setBounds(395, 22, 211, 30);
		panel.add(clockPanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(10, 98, 616, 355);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel signupLabel = new JLabel("會員註冊");
		signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signupLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		signupLabel.setBounds(248, 10, 113, 37);
		mainPanel.add(signupLabel);
		
		JLabel usernameLabel = new JLabel("帳號:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		usernameLabel.setBounds(10, 61, 92, 29);
		mainPanel.add(usernameLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		textField.setBounds(112, 63, 140, 29);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		JLabel usernameHintLabel = new JLabel("帳號為6~16位英文數字，首位不能為數字");
		usernameHintLabel.setForeground(new Color(0, 0, 0));
		usernameHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		usernameHintLabel.setBounds(10, 87, 242, 29);
		mainPanel.add(usernameHintLabel);
		
		JLabel passwordLabel = new JLabel("密碼:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		passwordLabel.setBounds(10, 126, 92, 29);
		mainPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		passwordField.setBounds(112, 128, 140, 29);
		mainPanel.add(passwordField);
		
		JLabel passwordHintLabel = new JLabel("密碼為6~20位，須包含英文大小寫與數字");
		passwordHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordHintLabel.setForeground(Color.BLACK);
		passwordHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		passwordHintLabel.setBounds(10, 153, 242, 29);
		mainPanel.add(passwordHintLabel);
		
		JLabel confirmLabel = new JLabel("確認密碼:");
		confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		confirmLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		confirmLabel.setBounds(10, 192, 92, 29);
		mainPanel.add(confirmLabel);
		
		confirmField = new JPasswordField();
		confirmField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		confirmField.setBounds(112, 192, 140, 29);
		confirmField.setBorder(new LineBorder(Color.gray));
		mainPanel.add(confirmField);
		
		JLabel nameLabel = new JLabel("姓名:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		nameLabel.setBounds(288, 61, 92, 29);
		mainPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		nameField.setColumns(10);
		nameField.setBounds(390, 63, 140, 29);
		mainPanel.add(nameField);
		
		JLabel nameHintLabel = new JLabel("2~16位中英文字");
		nameHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameHintLabel.setForeground(Color.BLACK);
		nameHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		nameHintLabel.setBounds(400, 87, 113, 29);
		mainPanel.add(nameHintLabel);
		
		JLabel addressLabel = new JLabel("地址:");
		addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		addressLabel.setBounds(288, 126, 70, 29);
		mainPanel.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		addressField.setColumns(10);
		addressField.setBounds(368, 128, 216, 29);
		mainPanel.add(addressField);
		
		JLabel emailLabel = new JLabel("電子郵件:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		emailLabel.setBounds(288, 190, 70, 29);
		mainPanel.add(emailLabel);
		
		JLabel phoneLabel = new JLabel("手機:");
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		phoneLabel.setBounds(288, 243, 92, 29);
		mainPanel.add(phoneLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		emailField.setColumns(10);
		emailField.setBounds(368, 192, 216, 29);
		mainPanel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(390, 245, 140, 29);
		mainPanel.add(phoneField);
		
		JLabel addressHintLabel = new JLabel("地址請勿空白");
		addressHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressHintLabel.setForeground(Color.BLACK);
		addressHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		addressHintLabel.setBounds(368, 153, 145, 29);
		mainPanel.add(addressHintLabel);
		
		JLabel emailHintLabel = new JLabel("須為電郵格式");
		emailHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailHintLabel.setForeground(Color.BLACK);
		emailHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		emailHintLabel.setBounds(368, 218, 145, 29);
		mainPanel.add(emailHintLabel);
		
		JLabel phoneHintLabel = new JLabel("09開頭10位數字");
		phoneHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneHintLabel.setForeground(Color.BLACK);
		phoneHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		phoneHintLabel.setBounds(400, 273, 113, 29);
		mainPanel.add(phoneHintLabel);
		
		JButton signupButton = new JButton("註冊");
		signupButton.setBackground(new Color(0, 225, 0));
		signupButton.setForeground(new Color(255, 255, 255));
		signupButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		signupButton.setBounds(248, 300, 113, 37);
		mainPanel.add(signupButton);
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}

}
