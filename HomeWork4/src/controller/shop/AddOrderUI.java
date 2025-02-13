package controller.shop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import model.ShopMember;
import model.ShopOrder;
import service.impl.ProductServiceImpl;
import util.ClockPanel;
import util.FileTool;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField ps5proField;
	private JFormattedTextField ps5slimField;
	private JFormattedTextField nswitchField;
	private JFormattedTextField steamdeckField;
	private JFormattedTextField xboxField;
	private JLabel sumLabel;
	private static ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	private static int ps5proPrice;
	private static int ps5slimPrice;
	private static int nswitchPrice;
	private static int steamdeckPrice;
	private static int xboxcontrollerPrice;
	private ShopMember member;
	private ShopOrder order;

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
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//獲取每個產品的單價
		ps5proPrice = productServiceImpl.getPrice("ps5pro");
		ps5slimPrice = productServiceImpl.getPrice("ps5slim");
		nswitchPrice = productServiceImpl.getPrice("nswitch");
		steamdeckPrice = productServiceImpl.getPrice("steamdeck");
		xboxcontrollerPrice = productServiceImpl.getPrice("xboxcontroller");
		
		//讀取用戶資訊與初始化訂單
		member = (ShopMember) FileTool.load("ShopMember.txt");
		order = new ShopOrder();
		order.setUsername(member.getUsername());
		
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
		
		//讓輸入限制在0~999的數字內
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(format);
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setCommitsOnValidEdit(true);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(999);
		
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
		productLabel.setBounds(10, 160, 155, 33);
		contentPane.add(productLabel);
		
		JLabel ps5proPriceLabel = new JLabel();
		ps5proPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ps5proPriceLabel.setForeground(Color.BLACK);
		ps5proPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		ps5proPriceLabel.setBounds(330, 160, 139, 33);
		contentPane.add(ps5proPriceLabel);
		ps5proPriceLabel.setText("單價:"+ps5proPrice+"元");
		
		ps5proField = new JFormattedTextField(numberFormatter);
		ps5proField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcSum();
			}
		});
		ps5proField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		ps5proField.setText("0");
		ps5proField.setHorizontalAlignment(SwingConstants.CENTER);
		ps5proField.setBounds(210, 160, 60, 38);
		contentPane.add(ps5proField);
		
		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) ps5proField.getValue();
				if (n > 0) {
					ps5proField.setValue(n-1);
					calcSum();
				}
				
			}
		});
		subtractButton.setForeground(new Color(255, 255, 255));
		subtractButton.setBackground(new Color(32, 175, 234));
		subtractButton.setMargin(new Insets(1, 1, 1, 1));
		subtractButton.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton.setBounds(175, 164, 30, 30);
		contentPane.add(subtractButton);
		
		JButton addButton = new JButton("+");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) ps5proField.getValue();
				if (n < 999) {
					ps5proField.setValue(n+1);;
					calcSum();
				}
			}
		});
		addButton.setMargin(new Insets(1, 1, 1, 1));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton.setBackground(new Color(32, 175, 234));
		addButton.setBounds(275, 164, 30, 30);
		contentPane.add(addButton);
		
		JLabel productLabel_1 = new JLabel("PS5 Slim:");
		productLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_1.setForeground(Color.BLACK);
		productLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_1.setBounds(10, 220, 155, 33);
		contentPane.add(productLabel_1);
		
		JButton subtractButton_1 = new JButton("-");
		subtractButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) ps5slimField.getValue();
				if (n > 0) {
					ps5slimField.setValue(n-1);
					calcSum();
				}
			}
		});
		subtractButton_1.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_1.setForeground(Color.WHITE);
		subtractButton_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_1.setBackground(new Color(32, 175, 234));
		subtractButton_1.setBounds(175, 224, 30, 30);
		contentPane.add(subtractButton_1);
		
		ps5slimField = new JFormattedTextField(numberFormatter);
		ps5slimField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcSum();
			}
		});
		ps5slimField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		ps5slimField.setText("0");
		ps5slimField.setHorizontalAlignment(SwingConstants.CENTER);
		ps5slimField.setBounds(210, 220, 60, 38);
		contentPane.add(ps5slimField);
		
		JButton addButton_1 = new JButton("+");
		addButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) ps5slimField.getValue();
				if (n < 999) {
					ps5slimField.setValue(n+1);
					calcSum();
				}
			}
		});
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
		ps5slimPriceLabel.setText("單價:"+ps5slimPrice+"元");
		
		JLabel productLabel_2 = new JLabel("Nintendo Switch:");
		productLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_2.setForeground(Color.BLACK);
		productLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		productLabel_2.setBounds(10, 280, 155, 33);
		contentPane.add(productLabel_2);
		
		JButton subtractButton_2 = new JButton("-");
		subtractButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) nswitchField.getValue();
				if (n > 0) {
					nswitchField.setValue(n-1);
					calcSum();
				}
			}
		});
		subtractButton_2.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_2.setForeground(Color.WHITE);
		subtractButton_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_2.setBackground(new Color(32, 175, 234));
		subtractButton_2.setBounds(175, 284, 30, 30);
		contentPane.add(subtractButton_2);
		
		nswitchField = new JFormattedTextField(numberFormatter);
		nswitchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcSum();
			}
		});
		nswitchField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		nswitchField.setText("0");
		nswitchField.setHorizontalAlignment(SwingConstants.CENTER);
		nswitchField.setBounds(210, 280, 60, 38);
		contentPane.add(nswitchField);
		
		JButton addButton_2 = new JButton("+");
		addButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) nswitchField.getValue();
				if (n < 999) {
					nswitchField.setValue(n+1);
					calcSum();
				}
			}
		});
		addButton_2.setMargin(new Insets(1, 1, 1, 1));
		addButton_2.setForeground(Color.WHITE);
		addButton_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_2.setBackground(new Color(32, 175, 234));
		addButton_2.setBounds(275, 284, 30, 30);
		contentPane.add(addButton_2);
		
		JLabel nswitchPriceLabel = new JLabel();
		nswitchPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nswitchPriceLabel.setForeground(Color.BLACK);
		nswitchPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		nswitchPriceLabel.setBounds(330, 280, 139, 33);
		contentPane.add(nswitchPriceLabel);
		nswitchPriceLabel.setText("單價:"+nswitchPrice+"元");
		
		JLabel productLabel_3 = new JLabel("Steam Deck:");
		productLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_3.setForeground(Color.BLACK);
		productLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_3.setBounds(10, 340, 155, 33);
		contentPane.add(productLabel_3);
		
		JButton subtractButton_3 = new JButton("-");
		subtractButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) steamdeckField.getValue();
				if (n > 0) {
					steamdeckField.setValue(n-1);
					calcSum();
				}
			}
		});
		subtractButton_3.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_3.setForeground(Color.WHITE);
		subtractButton_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_3.setBackground(new Color(32, 175, 234));
		subtractButton_3.setBounds(175, 344, 30, 30);
		contentPane.add(subtractButton_3);
		
		steamdeckField = new JFormattedTextField(numberFormatter);
		steamdeckField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcSum();
			}
		});
		steamdeckField.setText("0");
		steamdeckField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		steamdeckField.setHorizontalAlignment(SwingConstants.CENTER);
		steamdeckField.setBounds(210, 340, 60, 38);
		contentPane.add(steamdeckField);
		
		JButton addButton_3 = new JButton("+");
		addButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) steamdeckField.getValue();
				if (n < 999) {
					steamdeckField.setValue(n+1);
					calcSum();
				}
			}
		});
		addButton_3.setMargin(new Insets(1, 1, 1, 1));
		addButton_3.setForeground(Color.WHITE);
		addButton_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_3.setBackground(new Color(32, 175, 234));
		addButton_3.setBounds(275, 344, 30, 30);
		contentPane.add(addButton_3);
		
		JLabel steamdeckPriceLabel = new JLabel("");
		steamdeckPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		steamdeckPriceLabel.setForeground(Color.BLACK);
		steamdeckPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		steamdeckPriceLabel.setBounds(330, 340, 139, 33);
		contentPane.add(steamdeckPriceLabel);
		steamdeckPriceLabel.setText("單價:"+steamdeckPrice+"元");
		
		JLabel productLabel_4 = new JLabel("XBOX無線手把:");
		productLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_4.setForeground(Color.BLACK);
		productLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		productLabel_4.setBounds(10, 400, 155, 33);
		contentPane.add(productLabel_4);
		
		JButton subtractButton_4 = new JButton("-");
		subtractButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) xboxField.getValue();
				if (n > 0) {
					xboxField.setValue(n-1);
					calcSum();
				}
			}
		});
		subtractButton_4.setMargin(new Insets(1, 1, 1, 1));
		subtractButton_4.setForeground(Color.WHITE);
		subtractButton_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		subtractButton_4.setBackground(new Color(32, 175, 234));
		subtractButton_4.setBounds(175, 404, 30, 30);
		contentPane.add(subtractButton_4);
		
		xboxField = new JFormattedTextField(numberFormatter);
		xboxField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcSum();
			}
		});
		xboxField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		xboxField.setText("0");
		xboxField.setHorizontalAlignment(SwingConstants.CENTER);
		xboxField.setBounds(210, 400, 60, 38);
		contentPane.add(xboxField);
		
		JButton addButton_4 = new JButton("+");
		addButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n = (Integer) xboxField.getValue();
				if (n < 999) {
					xboxField.setValue(n+1);
					calcSum();
				}
			}
		});
		addButton_4.setMargin(new Insets(1, 1, 1, 1));
		addButton_4.setForeground(Color.WHITE);
		addButton_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		addButton_4.setBackground(new Color(32, 175, 234));
		addButton_4.setBounds(275, 404, 30, 30);
		contentPane.add(addButton_4);
		
		JLabel xboxPriceLabel = new JLabel();
		xboxPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		xboxPriceLabel.setForeground(Color.BLACK);
		xboxPriceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		xboxPriceLabel.setBounds(330, 400, 139, 33);
		contentPane.add(xboxPriceLabel);
		xboxPriceLabel.setText("單價:"+xboxcontrollerPrice+"元");
		
		sumLabel = new JLabel("總計： 0元");
		sumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sumLabel.setForeground(new Color(0, 0, 0));
		sumLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sumLabel.setBounds(124, 460, 236, 33);
		contentPane.add(sumLabel);
		
		JButton checkoutButton = new JButton("確認/結帳");
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (order.getSum()>0) {
					FileTool.save(order, "ShopOrder.txt");
					new CheckoutUI().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "沒有選購任何產品", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		checkoutButton.setForeground(new Color(255, 255, 255));
		checkoutButton.setBackground(new Color(0, 255, 0));
		checkoutButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		checkoutButton.setBounds(175, 503, 130, 36);
		contentPane.add(checkoutButton);
		
		JButton returnButton = new JButton("回上一頁");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI().setVisible(true);
				dispose();
			}
		});
		returnButton.setForeground(new Color(255, 255, 255));
		returnButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		returnButton.setBackground(new Color(255, 0, 0));
		returnButton.setBounds(19, 503, 130, 36);
		contentPane.add(returnButton);
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	
	//計算總合後顯示並記錄到ShopOrder物件
	private void calcSum() {
		int ps5pro = Integer.parseInt(ps5proField.getText());
		int ps5slim = Integer.parseInt(ps5slimField.getText());
		int nswitch = Integer.parseInt(nswitchField.getText());
		int steamdeck = Integer.parseInt(steamdeckField.getText());
		int xbox = Integer.parseInt(xboxField.getText());
		int sum = ps5pro * ps5proPrice
				+ ps5slim * ps5slimPrice
				+ nswitch * nswitchPrice
				+ steamdeck * steamdeckPrice
				+ xbox * xboxcontrollerPrice;
		sumLabel.setText("總計: "+sum+"元");
		order.setPs5pro(ps5pro);
		order.setPs5slim(ps5slim);
		order.setNswitch(nswitch);
		order.setSteamdeck(steamdeck);
		order.setXboxcontroller(xbox);
		order.setSum(sum);
	}
}
