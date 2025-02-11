package controller.login;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.ShopMember;
import service.impl.ShopMemberServiceImpl;
import util.ClockPanel;
import util.Helper;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accountField;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField emailField;
	private JTextField phoneField;
	private Border defaultBorder = new JTextField().getBorder();
	private Border errorBorder = new LineBorder(Color.red,2);
	private JButton signupButton;
	private ShopMemberServiceImpl shopMemberServiceImpl = new ShopMemberServiceImpl();

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
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 616, 78);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("普龍共");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel.setBounds(99, 5, 72, 33);
		titlePanel.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("電視遊樂器專賣店");
		subtitleLabel.setForeground(new Color(255, 255, 255));
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		subtitleLabel.setBounds(76, 48, 115, 20);
		titlePanel.add(subtitleLabel);
		
		ClockPanel clockPanel = new ClockPanel();
		clockPanel.setBackground(new Color(32, 175, 234));
		clockPanel.setBounds(395, 22, 211, 30);
		titlePanel.add(clockPanel);
		
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
		
		accountField = new JTextField();
		accountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validateUsername(accountField.getText())) {
					accountField.setBorder(defaultBorder);
				}else {
					accountField.setBorder(errorBorder);
				}
				passwordField.requestFocusInWindow();
			}
		});
		accountField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Helper.validateUsername(accountField.getText())) {
					accountField.setBorder(defaultBorder);
				}else {
					accountField.setBorder(errorBorder);
				}
			}
		});
		accountField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		accountField.setBounds(112, 63, 140, 29);
		mainPanel.add(accountField);
		accountField.setColumns(10);
		
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
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validatePassword(passwordField.getText())) {
					passwordField.setBorder(defaultBorder);
				}else {
					passwordField.setBorder(errorBorder);
				}
				confirmField.requestFocusInWindow();
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Helper.validatePassword(passwordField.getText())) {
					passwordField.setBorder(defaultBorder);
				}else {
					passwordField.setBorder(errorBorder);
				}
			}
		});
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
		confirmField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getText().equals(confirmField.getText())) {
					confirmField.setBorder(defaultBorder);
				}else {
					confirmField.setBorder(errorBorder);
				}
				nameField.requestFocusInWindow();
			}
		});
		confirmField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (passwordField.getText().equals(confirmField.getText())) {
					confirmField.setBorder(defaultBorder);
				}else {
					confirmField.setBorder(errorBorder);
				}
			}
		});
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
		nameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validateName(nameField.getText())) {
					nameField.setBorder(defaultBorder);
				}else {
					nameField.setBorder(errorBorder);
				}
				addressField.requestFocusInWindow();
			}
		});
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Helper.validateName(nameField.getText())) {
					nameField.setBorder(defaultBorder);
				}else {
					nameField.setBorder(errorBorder);
				}
			}
		});
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
		addressField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addressLabel.getText().isBlank()) {
					addressField.setBorder(errorBorder);
				}else {
					addressField.setBorder(defaultBorder);
				}
				emailField.requestFocusInWindow();
			}
		});
		addressField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (addressLabel.getText().isBlank()) {
					addressField.setBorder(errorBorder);
				}else {
					addressField.setBorder(defaultBorder);
				}
			}
		});
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
		emailField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validateEmail(emailField.getText())) {
					emailField.setBorder(defaultBorder);
				}else {
					emailField.setBorder(errorBorder);
				}
				phoneField.requestFocusInWindow();
			}
		});
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Helper.validateEmail(emailField.getText())) {
					emailField.setBorder(defaultBorder);
				}else {
					emailField.setBorder(errorBorder);
				}
			}
		});
		emailField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		emailField.setColumns(10);
		emailField.setBounds(368, 192, 216, 29);
		mainPanel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validatePhoneNumber(phoneField.getText())) {
					phoneField.setBorder(defaultBorder);
				}else {
					phoneField.setBorder(errorBorder);
				}
				signupButton.requestFocusInWindow();
			}
		});
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Helper.validatePhoneNumber(phoneField.getText())) {
					phoneField.setBorder(defaultBorder);
				}else {
					phoneField.setBorder(errorBorder);
				}
			}
		});
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
		
		signupButton = new JButton("註冊");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = accountField.getText();
				String password = passwordField.getText();
				String passwordCheck = confirmField.getText();
				String name = nameField.getText();
				String address = addressField.getText();
				String email = emailField.getText();
				String phone = phoneField.getText();
				if (validateAll(username, password, passwordCheck, name, address, email, phone)) {
					if (!shopMemberServiceImpl.isUsernameTaken(username)) {
						shopMemberServiceImpl.addMember(new ShopMember(username, password, name, address, email, phone, "customer"));
						JOptionPane.showMessageDialog(contentPane, "註冊成功!");
						new LoginUI().setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "帳號已被使用!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "請再次檢查輸入資料的格式!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		signupButton.setBackground(new Color(0, 225, 0));
		signupButton.setForeground(new Color(255, 255, 255));
		signupButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		signupButton.setBounds(248, 300, 113, 37);
		mainPanel.add(signupButton);
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	private boolean validateAll(String username, String password,String passwordCheck, String name, String address, String email, String phone) {
		return Helper.validateUsername(username) 
				&& Helper.validatePassword(password) 
				&& password.equals(passwordCheck) 
				&& Helper.validateName(name)
				&& !address.isBlank()
				&& Helper.validateEmail(email)
				&& Helper.validatePhoneNumber(phone);
	}
}
