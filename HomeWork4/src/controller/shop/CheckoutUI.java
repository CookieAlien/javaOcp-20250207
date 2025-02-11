package controller.shop;

import java.awt.EventQueue;
import java.awt.Font;

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
import service.impl.ShopOrderServiceImpl;
import util.ClockPanel;
import util.FileTool;
import util.Helper;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class CheckoutUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ShopMember member;
	private ShopOrder order;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFormattedTextField cashField;
	private JTextArea outputArea;
	private JButton checkoutButton;
	private JButton returnButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutUI frame = new CheckoutUI();
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
	public CheckoutUI() {
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//讀取資料
		member = (ShopMember) FileTool.load("ShopMember.txt");
		order = (ShopOrder) FileTool.load("ShopOrder.txt");
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(32, 175, 234));
		titlePanel.setBounds(10, 10, 616, 82);
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
		clockPanel.setBounds(398, 12, 208, 54);
		titlePanel.add(clockPanel);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBackground(new Color(255, 255, 255));
		confirmPanel.setBounds(10, 102, 259, 312);
		contentPane.add(confirmPanel);
		confirmPanel.setLayout(null);
		
		JLabel titleLabel_1 = new JLabel("確認與付款");
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setForeground(new Color(0, 0, 0));
		titleLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		titleLabel_1.setBounds(29, 10, 188, 33);
		confirmPanel.add(titleLabel_1);
		
		JLabel priceLabel = new JLabel();
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		priceLabel.setBounds(29, 53, 188, 46);
		priceLabel.setText("總額：$"+order.getSum());
		confirmPanel.add(priceLabel);
		
		
		JLabel paymentLabel = new JLabel("支付方式");
		paymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentLabel.setForeground(Color.BLACK);
		paymentLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		paymentLabel.setBounds(29, 107, 188, 33);
		confirmPanel.add(paymentLabel);
		
		JRadioButton cashRadio = new JRadioButton("現金");
		cashRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashField.setEnabled(true);
			}
		});
		buttonGroup.add(cashRadio);
		cashRadio.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		cashRadio.setBackground(new Color(255, 255, 255));
		cashRadio.setBounds(66, 146, 129, 23);
		cashRadio.setFocusPainted(false);
		confirmPanel.add(cashRadio);
		
		JRadioButton cardRadio = new JRadioButton("信用卡");
		cardRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashField.setEnabled(false);
				cashField.setText("");
			}
		});
		buttonGroup.add(cardRadio);
		cardRadio.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		cardRadio.setBackground(Color.WHITE);
		cardRadio.setBounds(66, 171, 129, 23);
		cardRadio.setFocusPainted(false);
		confirmPanel.add(cardRadio);
		
		JRadioButton excelRadio = new JRadioButton("Excel Pay");
		excelRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashField.setEnabled(false);
				cashField.setText("");
			}
		});
		excelRadio.setToolTipText("早安");
		buttonGroup.add(excelRadio);
		excelRadio.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		excelRadio.setBackground(Color.WHITE);
		excelRadio.setBounds(66, 196, 129, 23);
		excelRadio.setFocusPainted(false);
		confirmPanel.add(excelRadio);
		
		JLabel cashLabel = new JLabel("現金付款:");
		cashLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cashLabel.setForeground(Color.BLACK);
		cashLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cashLabel.setBounds(10, 225, 77, 33);
		confirmPanel.add(cashLabel);
		
		//讓輸入限制在0~99999999的數字內
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(format);
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setCommitsOnValidEdit(true);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(99999999);
		
		
		cashField = new JFormattedTextField(numberFormatter);
		cashField.setEnabled(false);
		cashField.setBounds(97, 230, 98, 28);
		confirmPanel.add(cashField);
		
		checkoutButton = new JButton("結帳");
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cashRadio.isSelected()) {
					try {
						int cash = Integer.parseInt(cashField.getText());
						if (cash >= order.getSum()) {
							outputArea.setText(Helper.cashPaymentInfo(member.getName(), order, cash));
							finishPayment();
						} else {
							JOptionPane.showMessageDialog(contentPane, "支付金額不足!", "警告", JOptionPane.WARNING_MESSAGE);
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(contentPane, "輸入金額異常!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} else if (cardRadio.isSelected()) {
					String nameinput = JOptionPane.showInputDialog("刷卡請簽名(需與帳號的姓名相同)");
					if (nameinput.equals(member.getName())) {
						outputArea.setText(Helper.getShoppingInfo(nameinput, order)+"\n刷卡付款");
						finishPayment();
					}else {
						JOptionPane.showMessageDialog(contentPane, "簽名與會員姓名不同!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} else if (excelRadio.isSelected()) {
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "沒有選擇支付方式!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		checkoutButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		checkoutButton.setForeground(new Color(255, 255, 255));
		checkoutButton.setBackground(new Color(0, 255, 0));
		checkoutButton.setBounds(81, 268, 85, 34);
		confirmPanel.add(checkoutButton);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(new Color(192, 192, 192));
		outputPanel.setBounds(279, 102, 347, 312);
		contentPane.add(outputPanel);
		outputPanel.setLayout(null);
		
		JLabel titleLabel_2 = new JLabel("訊息輸出");
		titleLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_2.setForeground(Color.WHITE);
		titleLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		titleLabel_2.setBounds(81, 10, 188, 33);
		outputPanel.add(titleLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 42, 307, 225);
		outputPanel.add(scrollPane);
		
		outputArea = new JTextArea();
		outputArea.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		outputArea.setEditable(false);
		outputArea.setText(Helper.getShoppingInfo(member.getName(), order));
		scrollPane.setViewportView(outputArea);
		
		JButton printButton = new JButton("列印");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					outputArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		printButton.setForeground(new Color(0, 0, 0));
		printButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		printButton.setBackground(new Color(255, 255, 255));
		printButton.setBounds(126, 277, 85, 25);
		outputPanel.add(printButton);
		
		returnButton = new JButton("回上一頁");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddOrderUI().setVisible(true);
				dispose();
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(73, 424, 117, 34);
		contentPane.add(returnButton);
		
		JButton endButton = new JButton("完成");
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI().setVisible(true);
				dispose();
			}
		});
		endButton.setForeground(Color.BLACK);
		endButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		endButton.setBackground(Color.WHITE);
		endButton.setBounds(406, 424, 85, 34);
		contentPane.add(endButton);
		
		
		
		new Timer(1000, e -> clockPanel.updateTime()).start();
	}
	
	private void finishPayment() {
		new ShopOrderServiceImpl().addOrder(order);
		JOptionPane.showMessageDialog(contentPane, "感謝您的訂購!");
		checkoutButton.setEnabled(false);
		returnButton.setEnabled(false);
	}
}
