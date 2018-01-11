package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.wsy.JComPz.Item;
import com.wsy.dao.Dao;
import com.wsy.model.BookInfo;
import com.wsy.model.BookType;
import com.wsy.model.Operater;
import com.wsy.util.MyDocument;

public class newBookOrderIFrame extends JInternalFrame {

	private JTextField bookName;
	private JTextField zk;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cbs;
	private JTextField price;
	private JComboBox bookType;
	private JTextField operator;
	private JTextField orderNumber;
	private JTextField ISBN;
	private JFormattedTextField orderDate;
	DefaultComboBoxModel bookTypeModel;
	DefaultComboBoxModel cbsModel;
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	Map map;
	DefaultTableModel model;
	private Operater user = BookLoginIFrame.getUser(); 


	/**
	 * Create the frame
	 */
	public newBookOrderIFrame() {
		super();
		setTitle("Book Ordering Management");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 600, 420);

		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(0, 240));
		getContentPane().add(panel);

		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Order info.", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_4.setPreferredSize(new Dimension(480, 120));
		final GridLayout gridLayout_1 = new GridLayout(0, 4);
		gridLayout_1.setVgap(8);
		panel_4.setLayout(gridLayout_1);
		panel.add(panel_4);

		final JLabel label_1 = new JLabel();
		panel_4.add(label_1);
		label_1.setText("Order Date：");

		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");
		orderDate = new JFormattedTextField(myfmt.getDateInstance());
		panel_4.add(orderDate);
		orderDate.setValue(new java.util.Date());
		orderDate.addKeyListener(new DateListener());

		final JLabel label_4 = new JLabel();
		panel_4.add(label_4);
		label_4.setText("Order number：");

		orderNumber = new JTextField();
		panel_4.add(orderNumber);
		orderNumber.setDocument(new MyDocument(4));
		orderNumber.addKeyListener(new NumberListener());
		final JLabel label_5 = new JLabel();
		panel_4.add(label_5);
		label_5.setText("Operator：");
		operator  =new JTextField(user.getName());
		panel_4.add(operator);
		
		operator.setEditable(false);
		final JLabel label_9 = new JLabel();
		panel_4.add(label_9);
		label_9.setText("Already checked?：");

		final JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);

		radioButton1 = new JRadioButton();
		radioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(radioButton1);
		panel_3.add(radioButton1);
		radioButton1.setText("Yes");

		radioButton2 = new JRadioButton();
		radioButton2.setSelected(true);
		buttonGroup.add(radioButton2);
		panel_3.add(radioButton2);
		radioButton2.setText("No");

		final JLabel label = new JLabel();
		panel_4.add(label);
		label.setText("Discount：");

		zk = new JTextField();
		zk.setDocument(new MyDocument(1));
		zk.addKeyListener(new NumberListener());
		panel_4.add(zk);


		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Bookinfo.", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(5);
		panel_1.setLayout(gridLayout);
		panel_1.setPreferredSize(new Dimension(0, 100));
		getContentPane().add(panel_1, BorderLayout.NORTH);

		final JLabel label_3 = new JLabel();
		label_3.setText("ISBN：");
		panel_1.add(label_3);

		ISBN = new JTextField();
		ISBN.setDocument(new MyDocument(13));
		//ISBN.addKeyListener(new ISBNListener());
		ISBN.addFocusListener(new ISBNListenerlostFocus());
		panel_1.add(ISBN);

		final JLabel label_2 = new JLabel();
		label_2.setText("Book Name：");
		panel_1.add(label_2);

		bookName = new JTextField();
		panel_1.add(bookName);

		final JLabel label_6 = new JLabel();
		label_6.setText("Booktype：");
		panel_1.add(label_6);

		bookType = new JComboBox();
		bookTypeModel= (DefaultComboBoxModel)bookType.getModel();
		panel_1.add(bookType);

		final JLabel label_8 = new JLabel();
		label_8.setText("Press：");
		panel_1.add(label_8);
		cbs = new JComboBox();
		cbsModel=(DefaultComboBoxModel)cbs.getModel();
		panel_1.add(cbs);

		final JLabel label_7 = new JLabel();
		label_7.setText("Book Price：");
		panel_1.add(label_7);

		price = new JTextField();
		price.setDocument(new MyDocument(5));
		panel_1.add(price);


		
		map=new HashMap();
		//从数据库中取出图书类别
		List list=Dao.selectBookCategory();
		for(int i=0;i<list.size();i++){
			BookType booktype=(BookType)list.get(i);
			Item item=new Item();
			item.setId((String)booktype.getId());
			item.setName((String)booktype.getTypeName());
			bookTypeModel.addElement(item);
			map.put(item.getId(), item);
			
		}
		String[] array=new String[]{"***Press","**University","**Institution","***Web"};
		cbs.setModel(new DefaultComboBoxModel(array));

		final JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(0, 50));
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		final JButton buttonAdd = new JButton();
		buttonAdd.setText("Add");
		buttonAdd.addActionListener(new ButtonAddLisenter());
		panel_2.add(buttonAdd);

		final JButton ButtonExit = new JButton();
		ButtonExit.setText("Exit");
		ButtonExit.addActionListener(new CloseActionListener());
		panel_2.add(ButtonExit);
		setVisible(true);
		//
	}
	class ButtonAddLisenter implements ActionListener{
		public void actionPerformed(final ActionEvent e) {
			if(orderDate.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Date cannot be null");
				return;
			}
			if(ISBN.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "ISBN cannot be null");
				return;
			}
			if(orderNumber.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Book number cannot be null");
				return;
			}
			if(operator.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Operator cannot be null");
				return;
			}
			
			if(price.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Price cannot be null");
				return;
			}
			if(!Dao.selectBookOrder(ISBN.getText().trim()).isEmpty()){
				JOptionPane.showMessageDialog(null, "Two same ISBN！");
				return;
			}
			
			String checkAndAccept="0";
			if(radioButton2.isSelected()){
				checkAndAccept="1";
			}
			System.out.println(checkAndAccept);
			
			Double zks=Double.valueOf(zk.getText())/10;
			
			try{
				int i=Dao.InsertBookOrder(ISBN.getText().trim(), java.sql.Date.valueOf(orderDate.getText().trim()), orderNumber.getText().trim(), operator.getText().trim(), checkAndAccept,zks);
				System.out.println(i);
				if(i==1){
					JOptionPane.showMessageDialog(null, "Add successfully！");
				}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	class DateListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if(orderDate.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Time format is\"2017-12-10\"Format");
			}
		}
	}
	class NumberListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789"+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}
	class ISBNListener extends KeyAdapter {//使用回车键进行触发事件方法
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == '\n') { // 判断在文本框是否输入回车。
				String ISBNs = ISBN.getText().trim();
				List list = Dao.selectBookInfo(ISBNs);
				System.out.println(list.isEmpty());
				if(list.isEmpty()){
					new BookAddIFrame();
				}
				for (int i = 0; i < list.size(); i++) {
					BookInfo bookinfo = (BookInfo) list.get(i);
					bookName.setText(bookinfo.getBookname());
					bookType.setSelectedItem(map.get(bookinfo.getTypeid()));
					cbs.setSelectedItem(bookinfo.getPublisher());
					price.setText(String.valueOf(bookinfo.getPrice()));

				}
			}
		}
	}
	class ISBNListenerlostFocus extends FocusAdapter{
		public void focusLost(FocusEvent e){
			String ISBNs = ISBN.getText().trim();
			if(!Dao.selectBookOrder(ISBN.getText().trim()).isEmpty()){
				JOptionPane.showMessageDialog(null, "Already added！");
				ISBN.setText("");
				bookName.setText("");
				price.setText("");
				return;
			}
			List list = Dao.selectBookInfo(ISBNs);
			if(list.isEmpty()&&!ISBN.getText().isEmpty()){
				ISBN.setText("");
				bookName.setText("");
				price.setText("");
				JOptionPane.showMessageDialog(null, "No ISBN, please add.");
			}
			for (int i = 0; i < list.size(); i++) {
				BookInfo bookinfo = (BookInfo) list.get(i);
				bookName.setText(bookinfo.getBookname());
				bookType.setSelectedItem(map.get(bookinfo.getTypeid()));
				cbs.setSelectedItem(bookinfo.getPublisher());
				price.setText(String.valueOf(bookinfo.getPrice()));

			}
		}
	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
}
