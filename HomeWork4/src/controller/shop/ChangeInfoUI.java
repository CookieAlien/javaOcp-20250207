package controller.shop;

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
import util.FileTool;
import util.Helper;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeInfoUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField emailField;
	private JTextField phoneField;
	private Border defaultBorder = new JTextField().getBorder();
	private Border errorBorder = new LineBorder(Color.red,2);
	private JButton comfirmButton;
	private ShopMemberServiceImpl shopMemberServiceImpl = new ShopMemberServiceImpl();
	private JPasswordField oldPasswordField;
	private ShopMember member;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInfoUI frame = new ChangeInfoUI();
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
	public ChangeInfoUI() {
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//讀取當前使用者資料
		member = (ShopMember) FileTool.load("ShopMember.txt");
		
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
		
		JLabel changeInfoLabel = new JLabel("更新會員資料");
		changeInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changeInfoLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		changeInfoLabel.setBounds(221, 10, 159, 37);
		mainPanel.add(changeInfoLabel);
		
		JLabel usernameLabel = new JLabel("舊密碼:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		usernameLabel.setBounds(10, 61, 92, 29);
		mainPanel.add(usernameLabel);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		oldPasswordField.setBounds(112, 63, 140, 29);
		mainPanel.add(oldPasswordField);
		
		JLabel oldPasswordHintLabel = new JLabel("若無需修改密碼請空白");
		oldPasswordHintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		oldPasswordHintLabel.setForeground(Color.BLACK);
		oldPasswordHintLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		oldPasswordHintLabel.setBounds(10, 87, 242, 29);
		mainPanel.add(oldPasswordHintLabel);
		
		JLabel passwordLabel = new JLabel("新密碼:");
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
		nameField.setText(member.getName());
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
		addressField.setText(member.getAddress());
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
		emailField.setText(member.getEmail());
		mainPanel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.validatePhoneNumber(phoneField.getText())) {
					phoneField.setBorder(defaultBorder);
				}else {
					phoneField.setBorder(errorBorder);
				}
				comfirmButton.requestFocusInWindow();
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
		phoneField.setText(member.getPhone());
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
		
		comfirmButton = new JButton("確認修改");
		comfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPassword = oldPasswordField.getText();
				String password = passwordField.getText();
				String passwordCheck = confirmField.getText();
				String name = nameField.getText();
				String address = addressField.getText();
				String email = emailField.getText();
				String phone = phoneField.getText();
				if (password.isBlank()) {
					if (validateAll(name, address, email, phone)) {
						member.setName(name);
						member.setAddress(address);
						member.setEmail(email);
						member.setPhone(phone);
						shopMemberServiceImpl.updateMember(member);
						FileTool.save(member, "ShopMember.txt");
						JOptionPane.showMessageDialog(contentPane, "修改資料成功!");
						new MainMenuUI().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane, "請再次檢查輸入資料的格式!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					if (verifyPassword(oldPassword)) {
						if (validateAll(password, passwordCheck, name, address, email, phone)) {
							member.setPassword(password);
							member.setName(name);
							member.setAddress(address);
							member.setEmail(email);
							member.setPhone(phone);
							shopMemberServiceImpl.updateMember(member);
							FileTool.save(member, "ShopMember.txt");
							JOptionPane.showMessageDialog(contentPane, "修改資料成功!");
							new MainMenuUI().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(contentPane, "請再次檢查輸入資料的格式!", "警告", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "舊密碼輸入錯誤!", "警告", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		comfirmButton.setBackground(new Color(0, 225, 0));
		comfirmButton.setForeground(new Color(255, 255, 255));
		comfirmButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		comfirmButton.setBounds(248, 300, 113, 37);
		mainPanel.add(comfirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI().setVisible(true);
				dispose();
			}
		});
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		cancelButton.setBackground(new Color(255, 0, 0));
		cancelButton.setBounds(67, 300, 113, 37);
		mainPanel.add(cancelButton);
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	private boolean verifyPassword(String password) {
		return password.equals(member.getPassword());
	}
	private boolean validateAll(String password,String passwordCheck, String name, String address, String email, String phone) {
		return Helper.validatePassword(password) 
				&& password.equals(passwordCheck) 
				&& Helper.validateName(name)
				&& !address.isBlank()
				&& Helper.validateEmail(email)
				&& Helper.validatePhoneNumber(phone);
	}
	private boolean validateAll(String name, String address, String email, String phone) {
		return Helper.validateName(name)
				&& !address.isBlank()
				&& Helper.validateEmail(email)
				&& Helper.validatePhoneNumber(phone);
		}
}

