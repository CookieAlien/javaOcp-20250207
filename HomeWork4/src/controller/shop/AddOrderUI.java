package controller.shop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.ClockPanel;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AddOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrderUI frame = new AddOrderUI();
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
	public AddOrderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 476, 80);
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
		
		JLabel titleLabel_1 = new JLabel("新增訂單");
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setForeground(new Color(0, 0, 0));
		titleLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		titleLabel_1.setBounds(149, 100, 188, 33);
		contentPane.add(titleLabel_1);
		
		JLabel productLabel = new JLabel("PS5 PRO:");
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel.setForeground(Color.BLACK);
		productLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel.setBounds(10, 160, 139, 33);
		contentPane.add(productLabel);
		
		JLabel ps5proPriceLabel = new JLabel("24860元");
		ps5proPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ps5proPriceLabel.setForeground(Color.BLACK);
		ps5proPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		ps5proPriceLabel.setBounds(330, 160, 139, 33);
		contentPane.add(ps5proPriceLabel);
		
		JFormattedTextField ps5proField = new JFormattedTextField();
		ps5proField.setBounds(210, 160, 60, 38);
		contentPane.add(ps5proField);
		
		JButton subtractButton = new JButton("-");
		subtractButton.setForeground(new Color(255, 255, 255));
		subtractButton.setBackground(new Color(32, 175, 234));
		subtractButton.setMargin(new Insets(1, 1, 1, 1));
		subtractButton.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton.setBounds(175, 164, 30, 30);
		contentPane.add(subtractButton);
		
		JButton addButton = new JButton("-");
		addButton.setMargin(new Insets(1, 1, 1, 1));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton.setBackground(new Color(32, 175, 234));
		addButton.setBounds(275, 164, 30, 30);
		contentPane.add(addButton);
		
		JLabel productLabel_1 = new JLabel("PS5 PRO:");
		productLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_1.setForeground(Color.BLACK);
		productLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_1.setBounds(10, 220, 139, 33);
		contentPane.add(productLabel_1);
		
		JButton subtractButton_1 = new JButton("-");
		subtractButton_1.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_1.setForeground(Color.WHITE);
		subtractButton_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_1.setBackground(new Color(32, 175, 234));
		subtractButton_1.setBounds(175, 224, 30, 30);
		contentPane.add(subtractButton_1);
		
		JFormattedTextField ps5slimField = new JFormattedTextField();
		ps5slimField.setBounds(210, 220, 60, 38);
		contentPane.add(ps5slimField);
		
		JButton addButton_1 = new JButton("-");
		addButton_1.setMargin(new Insets(1, 1, 1, 1));
		addButton_1.setForeground(Color.WHITE);
		addButton_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_1.setBackground(new Color(32, 175, 234));
		addButton_1.setBounds(275, 224, 30, 30);
		contentPane.add(addButton_1);
		
		JLabel ps5slimPriceLabel = new JLabel("24860元");
		ps5slimPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ps5slimPriceLabel.setForeground(Color.BLACK);
		ps5slimPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		ps5slimPriceLabel.setBounds(330, 220, 139, 33);
		contentPane.add(ps5slimPriceLabel);
		
		JLabel productLabel_2 = new JLabel("PS5 PRO:");
		productLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_2.setForeground(Color.BLACK);
		productLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_2.setBounds(10, 280, 139, 33);
		contentPane.add(productLabel_2);
		
		JButton subtractButton_2 = new JButton("-");
		subtractButton_2.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_2.setForeground(Color.WHITE);
		subtractButton_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_2.setBackground(new Color(32, 175, 234));
		subtractButton_2.setBounds(175, 284, 30, 30);
		contentPane.add(subtractButton_2);
		
		JFormattedTextField nswitchField = new JFormattedTextField();
		nswitchField.setBounds(210, 280, 60, 38);
		contentPane.add(nswitchField);
		
		JButton addButton_2 = new JButton("-");
		addButton_2.setMargin(new Insets(1, 1, 1, 1));
		addButton_2.setForeground(Color.WHITE);
		addButton_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_2.setBackground(new Color(32, 175, 234));
		addButton_2.setBounds(275, 284, 30, 30);
		contentPane.add(addButton_2);
		
		JLabel nswitchPriceLabel = new JLabel("24860元");
		nswitchPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nswitchPriceLabel.setForeground(Color.BLACK);
		nswitchPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		nswitchPriceLabel.setBounds(330, 280, 139, 33);
		contentPane.add(nswitchPriceLabel);
		
		JLabel productLabel_3 = new JLabel("PS5 PRO:");
		productLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_3.setForeground(Color.BLACK);
		productLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_3.setBounds(10, 340, 139, 33);
		contentPane.add(productLabel_3);
		
		JButton subtractButton_3 = new JButton("-");
		subtractButton_3.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_3.setForeground(Color.WHITE);
		subtractButton_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_3.setBackground(new Color(32, 175, 234));
		subtractButton_3.setBounds(175, 344, 30, 30);
		contentPane.add(subtractButton_3);
		
		JFormattedTextField steamdeckField = new JFormattedTextField();
		steamdeckField.setBounds(210, 340, 60, 38);
		contentPane.add(steamdeckField);
		
		JButton addButton_3 = new JButton("-");
		addButton_3.setMargin(new Insets(1, 1, 1, 1));
		addButton_3.setForeground(Color.WHITE);
		addButton_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_3.setBackground(new Color(32, 175, 234));
		addButton_3.setBounds(275, 344, 30, 30);
		contentPane.add(addButton_3);
		
		JLabel steamdeckPriceLabel = new JLabel("24860元");
		steamdeckPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		steamdeckPriceLabel.setForeground(Color.BLACK);
		steamdeckPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		steamdeckPriceLabel.setBounds(330, 340, 139, 33);
		contentPane.add(steamdeckPriceLabel);
		
		JLabel productLabel_4 = new JLabel("PS5 PRO:");
		productLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_4.setForeground(Color.BLACK);
		productLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_4.setBounds(10, 400, 139, 33);
		contentPane.add(productLabel_4);
		
		JButton subtractButton_4 = new JButton("-");
		subtractButton_4.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_4.setForeground(Color.WHITE);
		subtractButton_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_4.setBackground(new Color(32, 175, 234));
		subtractButton_4.setBounds(175, 404, 30, 30);
		contentPane.add(subtractButton_4);
		
		JFormattedTextField xboxField = new JFormattedTextField();
		xboxField.setBounds(210, 400, 60, 38);
		contentPane.add(xboxField);
		
		JButton addButton_4 = new JButton("-");
		addButton_4.setMargin(new Insets(1, 1, 1, 1));
		addButton_4.setForeground(Color.WHITE);
		addButton_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_4.setBackground(new Color(32, 175, 234));
		addButton_4.setBounds(275, 404, 30, 30);
		contentPane.add(addButton_4);
		
		JLabel xboxPriceLabel = new JLabel("24860元");
		xboxPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		xboxPriceLabel.setForeground(Color.BLACK);
		xboxPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		xboxPriceLabel.setBounds(330, 400, 139, 33);
		contentPane.add(xboxPriceLabel);
		
		JLabel titleLabel_1_1 = new JLabel("總計： 0元");
		titleLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1_1.setForeground(new Color(0, 0, 0));
		titleLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel_1_1.setBounds(149, 460, 188, 33);
		contentPane.add(titleLabel_1_1);
		
		JButton btnNewButton = new JButton("確認/結帳");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnNewButton.setBounds(175, 503, 130, 36);
		contentPane.add(btnNewButton);
	}
}
