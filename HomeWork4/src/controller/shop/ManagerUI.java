package controller.shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import model.ShopMember;
import model.ShopOrder;
import service.impl.ProductServiceImpl;
import service.impl.ShopMemberServiceImpl;
import service.impl.ShopOrderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import util.ClockPanel;
import util.FileTool;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	private static ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	private JFormattedTextField ps5proField;
	private JFormattedTextField ps5slimField;
	private JFormattedTextField nswitchField;
	private JFormattedTextField steamdeckField;
	private JFormattedTextField xboxfield;
	private JButton updateOrderButton;
	private ShopOrder orderToUpdate;
	private JTextField findaccField;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private ShopMember member;
	private JButton updateBtn_1;

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
		setTitle("普龍共電視遊樂器專賣店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		member = (ShopMember) FileTool.load("Shopmember.txt");
		
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
		
		JLabel managerLabel = new JLabel("操作員：");
		managerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		managerLabel.setForeground(Color.WHITE);
		managerLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		managerLabel.setBounds(458, 22, 267, 33);
		managerLabel.setText("操作員："+member.getName());
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
		
		JButton viewAllButton = new JButton("查詢全部訂單");
		viewAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAllOrders();
			}
		});
		viewAllButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		viewAllButton.setBackground(new Color(255, 255, 255));
		viewAllButton.setBounds(10, 20, 114, 36);
		viewAllButton.setMargin(new Insets(1, 1, 1, 1));
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
		updateIDLabel.setBounds(118, 10, 35, 39);
		updateOrderPanel.add(updateIDLabel);
		
		updateIDField = new JTextField();
		updateIDField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				updateOrderButton.setEnabled(false);
			}
		});
		updateIDField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		updateIDField.setColumns(10);
		updateIDField.setBounds(163, 17, 91, 29);
		updateOrderPanel.add(updateIDField);
		
		JButton getOrderButton = new JButton("查詢訂單");
		getOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(updateIDField.getText());
					findOrderToUpdate(id);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "ID格式須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		getOrderButton.setMargin(new Insets(1, 1, 1, 1));
		getOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		getOrderButton.setBackground(Color.WHITE);
		getOrderButton.setBounds(282, 13, 91, 36);
		updateOrderPanel.add(getOrderButton);
		
		updateOrderButton = new JButton("更新訂單");
		updateOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(contentPane, "確定要更新訂單ID:"+orderToUpdate.getId()+"?原訂單內容會被覆蓋!", "訊息", JOptionPane.YES_NO_OPTION);
				if (select == JOptionPane.YES_OPTION) {
					UpdateOrder();
				}
			}
		});
		updateOrderButton.setEnabled(false);
		updateOrderButton.setForeground(new Color(255, 255, 255));
		updateOrderButton.setMargin(new Insets(1, 1, 1, 1));
		updateOrderButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		updateOrderButton.setBackground(new Color(0, 255, 0));
		updateOrderButton.setBounds(444, 13, 91, 36);
		updateOrderPanel.add(updateOrderButton);
		
		JLabel updateIDLabel_1 = new JLabel("更新訂單");
		updateIDLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		updateIDLabel_1.setForeground(Color.WHITE);
		updateIDLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		updateIDLabel_1.setBounds(10, 10, 98, 39);
		updateOrderPanel.add(updateIDLabel_1);
		
		//讓輸入限制在0~999的數字內
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(format);
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(999);
		
		JLabel productLabel = new JLabel("PS5 PRO:");
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel.setForeground(Color.WHITE);
		productLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		productLabel.setBounds(20, 60, 96, 39);
		updateOrderPanel.add(productLabel);
		
		ps5proField = new JFormattedTextField(numberFormatter);
		ps5proField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (ps5proField.getText().isBlank()) {
					ps5proField.setValue(0);
				}
			}
		});
		ps5proField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		ps5proField.setColumns(10);
		ps5proField.setBounds(126, 65, 60, 29);
		updateOrderPanel.add(ps5proField);
		
		JLabel productLabel_1 = new JLabel("PS5 Slim:");
		productLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_1.setForeground(Color.WHITE);
		productLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		productLabel_1.setBounds(196, 59, 96, 39);
		updateOrderPanel.add(productLabel_1);
		
		ps5slimField = new JFormattedTextField(numberFormatter);
		ps5slimField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (ps5slimField.getText().isBlank()) {
					ps5slimField.setValue(0);
				}
			}
		});
		ps5slimField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		ps5slimField.setColumns(10);
		ps5slimField.setBounds(302, 65, 60, 29);
		updateOrderPanel.add(ps5slimField);
		
		JLabel productLabel_2 = new JLabel("Nintendo Switch:");
		productLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel_2.setForeground(Color.WHITE);
		productLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		productLabel_2.setBounds(372, 60, 148, 39);
		updateOrderPanel.add(productLabel_2);
		
		nswitchField = new JFormattedTextField(numberFormatter);
		nswitchField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (nswitchField.getText().isBlank()) {
					nswitchField.setValue(0);
				}
			}
		});
		nswitchField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		nswitchField.setColumns(10);
		nswitchField.setBounds(530, 65, 60, 29);
		updateOrderPanel.add(nswitchField);
		
		JLabel lblSteamDeck_1 = new JLabel("Steam Deck:");
		lblSteamDeck_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSteamDeck_1.setForeground(Color.WHITE);
		lblSteamDeck_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblSteamDeck_1.setBounds(66, 109, 118, 39);
		updateOrderPanel.add(lblSteamDeck_1);
		
		steamdeckField = new JFormattedTextField(numberFormatter);
		steamdeckField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (steamdeckField.getText().isBlank()) {
					steamdeckField.setValue(0);
				}
			}
		});
		steamdeckField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		steamdeckField.setColumns(10);
		steamdeckField.setBounds(194, 114, 60, 29);
		updateOrderPanel.add(steamdeckField);
		
		JLabel lblSteamDeck = new JLabel("XBOX 無線控制器:");
		lblSteamDeck.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSteamDeck.setForeground(Color.WHITE);
		lblSteamDeck.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblSteamDeck.setBounds(264, 109, 173, 39);
		updateOrderPanel.add(lblSteamDeck);
		
		xboxfield = new JFormattedTextField(numberFormatter);
		xboxfield.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (xboxfield.getText().isBlank()) {
					xboxfield.setValue(0);
				}
			}
		});
		xboxfield.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		xboxfield.setColumns(10);
		xboxfield.setBounds(447, 114, 60, 29);
		updateOrderPanel.add(xboxfield);
		
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
		
		JLabel updateIDLabel_1_1 = new JLabel("刪除訂單");
		updateIDLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		updateIDLabel_1_1.setForeground(Color.WHITE);
		updateIDLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		updateIDLabel_1_1.setBounds(10, 18, 101, 39);
		deleteOrderPanel.add(updateIDLabel_1_1);
		
		JPanel memberpanel = new JPanel();
		memberpanel.setBackground(new Color(255, 255, 255));
		memberpanel.setBounds(644, 91, 532, 278);
		contentPane.add(memberpanel);
		memberpanel.setLayout(null);
		
		JLabel titleLabel_1 = new JLabel("帳號資訊查詢");
		titleLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel_1.setForeground(new Color(0, 0, 0));
		titleLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		titleLabel_1.setBounds(10, 10, 158, 33);
		memberpanel.add(titleLabel_1);
		
		JLabel viewAccLabel_1 = new JLabel("帳號:");
		viewAccLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		viewAccLabel_1.setForeground(new Color(0, 0, 0));
		viewAccLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		viewAccLabel_1.setBounds(174, 10, 45, 39);
		memberpanel.add(viewAccLabel_1);
		
		findaccField = new JTextField();
		findaccField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		findaccField.setColumns(10);
		findaccField.setBounds(229, 15, 114, 29);
		memberpanel.add(findaccField);
		
		JButton btnacc_1 = new JButton("查詢個人資訊");
		btnacc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAccount();
			}
		});
		btnacc_1.setMargin(new Insets(1, 1, 1, 1));
		btnacc_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		btnacc_1.setBackground(Color.WHITE);
		btnacc_1.setBounds(353, 10, 104, 36);
		memberpanel.add(btnacc_1);
		
		JLabel infoLabel = new JLabel("姓名：");
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		infoLabel.setBounds(21, 71, 60, 33);
		memberpanel.add(infoLabel);
		
		JLabel infoLabel2 = new JLabel("地址：");
		infoLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel2.setForeground(Color.BLACK);
		infoLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		infoLabel2.setBounds(21, 114, 60, 33);
		memberpanel.add(infoLabel2);
		
		JLabel infoLabel3 = new JLabel("email：");
		infoLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel3.setForeground(Color.BLACK);
		infoLabel3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		infoLabel3.setBounds(21, 192, 70, 33);
		memberpanel.add(infoLabel3);
		
		JLabel infoLabel4 = new JLabel("電話：");
		infoLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel4.setForeground(Color.BLACK);
		infoLabel4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		infoLabel4.setBounds(21, 235, 60, 33);
		memberpanel.add(infoLabel4);
		
		nameLabel = new JLabel("");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		nameLabel.setBounds(80, 71, 382, 33);
		memberpanel.add(nameLabel);
		
		addressLabel = new JLabel("");
		addressLabel.setVerticalAlignment(SwingConstants.TOP);
		addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addressLabel.setForeground(Color.BLACK);
		addressLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		addressLabel.setBounds(80, 114, 432, 79);
		memberpanel.add(addressLabel);
		
		emailLabel = new JLabel("");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		emailLabel.setBounds(95, 192, 417, 33);
		memberpanel.add(emailLabel);
		
		phoneLabel = new JLabel("");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setForeground(Color.BLACK);
		phoneLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		phoneLabel.setBounds(80, 235, 382, 33);
		memberpanel.add(phoneLabel);
		
		JPanel pricepanel = new JPanel();
		pricepanel.setBackground(new Color(255, 255, 255));
		pricepanel.setBounds(644, 379, 532, 374);
		contentPane.add(pricepanel);
		pricepanel.setLayout(null);
		
		JLabel titleLabel_2 = new JLabel("商品價格設定");
		titleLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel_2.setForeground(Color.BLACK);
		titleLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		titleLabel_2.setBounds(10, 10, 158, 33);
		pricepanel.add(titleLabel_2);
		
		NumberFormatter priceFormatter = new NumberFormatter(format);
		priceFormatter.setValueClass(Integer.class);
		priceFormatter.setMinimum(0);
		priceFormatter.setMaximum(99999999);
		
		JLabel lblProduct = new JLabel("PS5 PRO");
		lblProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct.setForeground(Color.BLACK);
		lblProduct.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblProduct.setBounds(10, 50, 125, 33);
		pricepanel.add(lblProduct);
		
		JLabel oldprice = new JLabel("原價格：");
		oldprice.setHorizontalAlignment(SwingConstants.LEFT);
		oldprice.setForeground(Color.BLACK);
		oldprice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		oldprice.setBounds(10, 77, 84, 33);
		pricepanel.add(oldprice);
		
		JLabel ps5proOldPrice = new JLabel();
		ps5proOldPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		ps5proOldPrice.setForeground(Color.BLACK);
		ps5proOldPrice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		ps5proOldPrice.setBounds(89, 77, 120, 33);
		pricepanel.add(ps5proOldPrice);
		ps5proOldPrice.setText(productServiceImpl.getPrice("ps5pro")+"元");
		
		JLabel newprice = new JLabel("新價格：");
		newprice.setHorizontalAlignment(SwingConstants.LEFT);
		newprice.setForeground(Color.BLACK);
		newprice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		newprice.setBounds(219, 77, 84, 33);
		pricepanel.add(newprice);;
		
		JFormattedTextField ps5proPriceField = new JFormattedTextField(priceFormatter);
		ps5proPriceField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		ps5proPriceField.setColumns(10);
		ps5proPriceField.setBounds(301, 81, 94, 29);
		pricepanel.add(ps5proPriceField);
		
		JButton updateBtn = new JButton("更新");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int price = Integer.parseInt(ps5proPriceField.getText());
					if (price > 0) {
						productServiceImpl.updatePrice("ps5pro", price);
						JOptionPane.showMessageDialog(contentPane, "更新成功!");
						ps5proOldPrice.setText(productServiceImpl.getPrice("ps5pro")+"元");
					}else {
						JOptionPane.showMessageDialog(contentPane, "價格需大於0!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "價格須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		updateBtn.setMargin(new Insets(1, 1, 1, 1));
		updateBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		updateBtn.setBackground(Color.WHITE);
		updateBtn.setBounds(405, 81, 84, 29);
		pricepanel.add(updateBtn);
		
		JLabel lblProduct_1 = new JLabel("PS5 Slim");
		lblProduct_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct_1.setForeground(Color.BLACK);
		lblProduct_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblProduct_1.setBounds(10, 110, 125, 33);
		pricepanel.add(lblProduct_1);
		
		JLabel oldprice_1 = new JLabel("原價格：");
		oldprice_1.setHorizontalAlignment(SwingConstants.LEFT);
		oldprice_1.setForeground(Color.BLACK);
		oldprice_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		oldprice_1.setBounds(10, 139, 84, 33);
		pricepanel.add(oldprice_1);
		
		JLabel ps5slimOldPrice = new JLabel();
		ps5slimOldPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		ps5slimOldPrice.setForeground(Color.BLACK);
		ps5slimOldPrice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		ps5slimOldPrice.setBounds(89, 139, 120, 33);
		ps5slimOldPrice.setText(productServiceImpl.getPrice("ps5slim")+"元");
		pricepanel.add(ps5slimOldPrice);
		
		JLabel newprice_1 = new JLabel("新價格：");
		newprice_1.setHorizontalAlignment(SwingConstants.LEFT);
		newprice_1.setForeground(Color.BLACK);
		newprice_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		newprice_1.setBounds(219, 139, 84, 33);
		pricepanel.add(newprice_1);
		
		JFormattedTextField ps5slimPriceField = new JFormattedTextField(priceFormatter);
		ps5slimPriceField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		ps5slimPriceField.setColumns(10);
		ps5slimPriceField.setBounds(301, 143, 94, 29);
		pricepanel.add(ps5slimPriceField);
		
		updateBtn_1 = new JButton("更新");
		updateBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int price = Integer.parseInt(ps5slimPriceField.getText());
					if (price > 0) {
						productServiceImpl.updatePrice("ps5slim", price);
						JOptionPane.showMessageDialog(contentPane, "更新成功!");
						ps5slimOldPrice.setText(productServiceImpl.getPrice("ps5slim")+"元");
					}else {
						JOptionPane.showMessageDialog(contentPane, "價格需大於0!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "價格須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		updateBtn_1.setMargin(new Insets(1, 1, 1, 1));
		updateBtn_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		updateBtn_1.setBackground(Color.WHITE);
		updateBtn_1.setBounds(405, 143, 84, 29);
		pricepanel.add(updateBtn_1);
		
		JLabel lblProduct_2 = new JLabel("Nintendo Switch");
		lblProduct_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct_2.setForeground(Color.BLACK);
		lblProduct_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblProduct_2.setBounds(10, 174, 158, 33);
		pricepanel.add(lblProduct_2);
		
		JLabel oldprice_2 = new JLabel("原價格：");
		oldprice_2.setHorizontalAlignment(SwingConstants.LEFT);
		oldprice_2.setForeground(Color.BLACK);
		oldprice_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		oldprice_2.setBounds(10, 201, 84, 33);
		pricepanel.add(oldprice_2);
		
		JLabel nswitchOldPrice = new JLabel();
		nswitchOldPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		nswitchOldPrice.setForeground(Color.BLACK);
		nswitchOldPrice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		nswitchOldPrice.setBounds(89, 201, 120, 33);
		nswitchOldPrice.setText(productServiceImpl.getPrice("nswitch")+"元");
		pricepanel.add(nswitchOldPrice);
		
		JLabel newprice_2 = new JLabel("新價格：");
		newprice_2.setHorizontalAlignment(SwingConstants.LEFT);
		newprice_2.setForeground(Color.BLACK);
		newprice_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		newprice_2.setBounds(219, 201, 84, 33);
		pricepanel.add(newprice_2);
		
		JFormattedTextField nswitchPriceField = new JFormattedTextField(priceFormatter);
		nswitchPriceField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		nswitchPriceField.setColumns(10);
		nswitchPriceField.setBounds(301, 205, 94, 29);
		pricepanel.add(nswitchPriceField);
		
		JButton updateBtn_2 = new JButton("更新");
		updateBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int price = Integer.parseInt(nswitchPriceField.getText());
					if (price > 0) {
						productServiceImpl.updatePrice("nswitch", price);
						JOptionPane.showMessageDialog(contentPane, "更新成功!");
						nswitchOldPrice.setText(productServiceImpl.getPrice("nswitch")+"元");
					}else {
						JOptionPane.showMessageDialog(contentPane, "價格需大於0!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "價格須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		updateBtn_2.setMargin(new Insets(1, 1, 1, 1));
		updateBtn_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		updateBtn_2.setBackground(Color.WHITE);
		updateBtn_2.setBounds(405, 205, 84, 29);
		pricepanel.add(updateBtn_2);
		
		JLabel lblProduct_3 = new JLabel("Steam Deck");
		lblProduct_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct_3.setForeground(Color.BLACK);
		lblProduct_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblProduct_3.setBounds(10, 239, 158, 33);
		pricepanel.add(lblProduct_3);
		
		JLabel oldprice_3 = new JLabel("原價格：");
		oldprice_3.setHorizontalAlignment(SwingConstants.LEFT);
		oldprice_3.setForeground(Color.BLACK);
		oldprice_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		oldprice_3.setBounds(10, 268, 84, 33);
		pricepanel.add(oldprice_3);
		
		JLabel steamdeckOldPrice = new JLabel();
		steamdeckOldPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		steamdeckOldPrice.setForeground(Color.BLACK);
		steamdeckOldPrice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		steamdeckOldPrice.setBounds(89, 268, 120, 33);
		steamdeckOldPrice.setText(productServiceImpl.getPrice("steamdeck")+"元");
		pricepanel.add(steamdeckOldPrice);
		
		JLabel newprice_3 = new JLabel("新價格：");
		newprice_3.setHorizontalAlignment(SwingConstants.LEFT);
		newprice_3.setForeground(Color.BLACK);
		newprice_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		newprice_3.setBounds(219, 268, 84, 33);
		pricepanel.add(newprice_3);
		
		JFormattedTextField steamdeckPriceField = new JFormattedTextField(priceFormatter);
		steamdeckPriceField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		steamdeckPriceField.setColumns(10);
		steamdeckPriceField.setBounds(301, 272, 94, 29);
		pricepanel.add(steamdeckPriceField);
		
		JButton updateBtn_3 = new JButton("更新");
		updateBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int price = Integer.parseInt(steamdeckPriceField.getText());
					if (price > 0) {
						productServiceImpl.updatePrice("steamdeck", price);
						JOptionPane.showMessageDialog(contentPane, "更新成功!");
						steamdeckOldPrice.setText(productServiceImpl.getPrice("steamdeck")+"元");
					}else {
						JOptionPane.showMessageDialog(contentPane, "價格需大於0!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "價格須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		updateBtn_3.setMargin(new Insets(1, 1, 1, 1));
		updateBtn_3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		updateBtn_3.setBackground(Color.WHITE);
		updateBtn_3.setBounds(405, 272, 84, 29);
		pricepanel.add(updateBtn_3);
		
		JLabel lblProduct_4 = new JLabel("XBOX 無線手把");
		lblProduct_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct_4.setForeground(Color.BLACK);
		lblProduct_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblProduct_4.setBounds(10, 306, 158, 33);
		pricepanel.add(lblProduct_4);
		
		JLabel oldprice_4 = new JLabel("原價格：");
		oldprice_4.setHorizontalAlignment(SwingConstants.LEFT);
		oldprice_4.setForeground(Color.BLACK);
		oldprice_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		oldprice_4.setBounds(10, 331, 84, 33);
		pricepanel.add(oldprice_4);
		
		JLabel xboxOldPrice = new JLabel();
		xboxOldPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		xboxOldPrice.setForeground(Color.BLACK);
		xboxOldPrice.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		xboxOldPrice.setBounds(89, 331, 120, 33);
		xboxOldPrice.setText(productServiceImpl.getPrice("xboxcontroller")+"元");
		pricepanel.add(xboxOldPrice);
		
		JLabel newprice_4 = new JLabel("新價格：");
		newprice_4.setHorizontalAlignment(SwingConstants.LEFT);
		newprice_4.setForeground(Color.BLACK);
		newprice_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		newprice_4.setBounds(219, 331, 84, 33);
		pricepanel.add(newprice_4);
		
		JFormattedTextField xboxPriceField = new JFormattedTextField(priceFormatter);
		xboxPriceField.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		xboxPriceField.setColumns(10);
		xboxPriceField.setBounds(301, 335, 94, 29);
		pricepanel.add(xboxPriceField);
		
		JButton updateBtn_4 = new JButton("更新");
		updateBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int price = Integer.parseInt(xboxPriceField.getText());
					if (price > 0) {
						productServiceImpl.updatePrice("xboxcontroller", price);
						JOptionPane.showMessageDialog(contentPane, "更新成功!");
						xboxOldPrice.setText(productServiceImpl.getPrice("xboxcontroller")+"元");
					}else {
						JOptionPane.showMessageDialog(contentPane, "價格需大於0!", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "價格須為整數!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		updateBtn_4.setMargin(new Insets(1, 1, 1, 1));
		updateBtn_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		updateBtn_4.setBackground(Color.WHITE);
		updateBtn_4.setBounds(405, 335, 84, 29);
		pricepanel.add(updateBtn_4);
	
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
	//獲取該ID的訂單並於欄位填入資訊
	private void findOrderToUpdate(int id) {
		orderToUpdate = shopOrderServiceImpl.getOrderById(id);
		if (orderToUpdate==null) {
			JOptionPane.showMessageDialog(contentPane, "查無資訊!");
			return;
		}else {
			ps5proField.setValue(orderToUpdate.getPs5pro());
			ps5slimField.setValue(orderToUpdate.getPs5slim());
			nswitchField.setValue(orderToUpdate.getNswitch());
			steamdeckField.setValue(orderToUpdate.getSteamdeck());
			xboxfield.setValue(orderToUpdate.getXboxcontroller());
			updateOrderButton.setEnabled(true);
		}
	}
	//從欄位獲取資訊並更新
	private void UpdateOrder() {
		try {
			int ps5pro = Integer.parseInt(ps5proField.getText());
			int ps5slim = Integer.parseInt(ps5slimField.getText());
			int nswitch = Integer.parseInt(nswitchField.getText());
			int steamdeck = Integer.parseInt(steamdeckField.getText());
			int xbox = Integer.parseInt(xboxfield.getText());
			orderToUpdate.setPs5pro(ps5pro);
			orderToUpdate.setPs5slim(ps5slim);
			orderToUpdate.setNswitch(nswitch);
			orderToUpdate.setSteamdeck(steamdeck);
			orderToUpdate.setXboxcontroller(xbox);
			shopOrderServiceImpl.updateOrder(orderToUpdate);
			updateOrderButton.setEnabled(false);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, "請檢察輸入數量需為整數!", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}
	//查詢帳號的個人資訊
	private void viewAccount() {
		String username = findaccField.getText();
		ShopMember account = shopMemberServiceImpl.findMember(username);
		if (account==null) {
			JOptionPane.showMessageDialog(contentPane, "查無資訊!");
			return;
		}else {
			nameLabel.setText(account.getName());
			addressLabel.setText("<html>"+account.getAddress()+"</html>");
			emailLabel.setText(account.getEmail());
			phoneLabel.setText(account.getPhone());
		}
	}
}
