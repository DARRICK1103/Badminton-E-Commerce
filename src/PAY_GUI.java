import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class PAY_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JRadioButton RB_ShippingAddress;
	private JRadioButton RB_OTHERS;
	private JTextField Address;
	private JComboBox comboBox;
	private static int customerID;
	private static int orderID;
	private static int paymentID;
	private double total;

	/**
	 * Launch the application.
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PAY_GUI frame = new PAY_GUI(orderID, customerID,paymentID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateOrder(int orderID)
	{
		PAY_GUI.orderID = orderID;
	}
	
	public void updateCus(int customerID)
	{
		PAY_GUI.customerID = customerID;
	}
	public void updatePay(int paymentID)
	{
		PAY_GUI.paymentID = paymentID;
	}
	/**
	 * Create the frame.
	 */
	public PAY_GUI(int orderID, int customerID, int paymentID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 10, 284, 102);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(60, 179, 113)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECK OUT");
		lblNewLabel.setBounds(42, 10, 223, 88);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 687, 357);
		contentPane.add(scrollPane);
		
		listManager ListManager = new listManager();
		List <OrderList> list = ListManager.listOrder(orderID);
		productManager ProductManager = new productManager();
		total = 0;
		
	
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = {"NO.", "Product Name", "Quantity", "Subtotal (RM)"};
		model.setColumnIdentifiers(column);
		if(list != null)
		{
			int num = 1;
			for (OrderList orderlist : list) {
				  Object[] o = new Object[4];
				  o[0] = num;
				  Product product = ProductManager.get(orderlist.getProduct_ID());
				  o[1] = product.getProduct_Name();
				  o[2] = orderlist.getQuantity();
				  o[3] = orderlist.getSubtotal();
				  total+=orderlist.getSubtotal();
				  num++;
				  model.addRow(o);
				}
			
			table.setModel(model);
		}
		else
		{
			table.setModel(model);
		}
		
	
		JButton btnNEXT = new JButton("PAY");
		btnNEXT.setBounds(841, 624, 284, 65);
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(btnNEXT);
		btnNEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNEXTActionPerformed(evt);
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(724, 122, 439, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		customerManager CustomerManager = new customerManager();
		Customer customer = CustomerManager.get(customerID);
		String address = customer.getCustomer_Address();
		
		RB_ShippingAddress = new JRadioButton(address);
		RB_ShippingAddress.setBounds(6, 68, 412, 56);
		panel_1.add(RB_ShippingAddress);
		
		RB_OTHERS = new JRadioButton("OTHERS");
		RB_OTHERS.setBounds(6, 138, 412, 56);
		panel_1.add(RB_OTHERS);
		
		Address = new JTextField();
		Address.setBounds(6, 200, 412, 65);
		panel_1.add(Address);
		Address.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SHIPPING ADDRESS");
		lblNewLabel_1.setBounds(102, 0, 230, 73);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(736, 439, 439, 146);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String type[] = {"TNG eWallet", "BoostWallet", "GrabPay", "Bank Transfer"};
		comboBox = new JComboBox(type);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(109, 76, 198, 33);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("PAYMENT METHODS");
		lblNewLabel_1_1.setBounds(99, 10, 230, 73);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(73, 489, 585, 82);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		DecimalFormat df = new DecimalFormat("0.00");
		JLabel totalPrice = new JLabel("TOTAL PRICE: RM " + df.format(total));
		totalPrice.setBounds(46, 10, 529, 60);
		panel_3.add(totalPrice);
		totalPrice.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnAdd = new JButton("ADD MORE ITEMS");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAdd.setBounds(36, 624, 284, 65);
		contentPane.add(btnAdd);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
	}
	
	private void btnNEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
        	boolean checkCombo = checkCombo();
        	
        	if(checkCombo == true)
        	{
        		int checkAddress = checkText();
        		
        		paymentManager PaymentManager = new paymentManager();
        		Payment payment = PaymentManager.get(paymentID);
        		Object obj = comboBox.getItemAt(comboBox.getSelectedIndex());
        		String type = obj.toString();
        		payment.setPayment_Type(type);
        		payment.setTotal_Price(total);
        		PaymentManager.update(payment);
        		
        		customerManager CustomerManager = new customerManager();
        		
        		
        		ordersManager OrderManager = new ordersManager();
        		Order order = OrderManager.get(orderID);
        		if(checkAddress == 1) //use customer's address
        		{
        			Customer customer = CustomerManager.get(customerID);
        			order.setShip_Address(customer.getCustomer_Address());
        		}
        		else //customer type in themselves
        		{
        			String address = Address.getText();
            		order.setShip_Address(address);
            		
        		}
        		order.setStatus(1); //done payment
        		OrderManager.update(order);
        		if(type == "TNG eWallet")
        		{
        			ImageIcon iconic = new ImageIcon("C:\\Users\\User\\Desktop\\OOP_IMAGES\\TNG.png");
            		JOptionPane.showMessageDialog(null, "","Payemnt",JOptionPane.INFORMATION_MESSAGE, iconic);
            		
        		}
        		else if(type == "BoostWallet") 
        		{
        			ImageIcon iconic = new ImageIcon("C:\\Users\\User\\Desktop\\OOP_IMAGES\\bank.png");
            		JOptionPane.showMessageDialog(null, "","Payemnt",JOptionPane.INFORMATION_MESSAGE, iconic);
            		
        		}
        		else if(type == "GrabPay")
        		{
        			ImageIcon iconic = new ImageIcon("C:\\Users\\User\\Desktop\\OOP_IMAGES\\Grab.png");
            		JOptionPane.showMessageDialog(null, "","Payemnt",JOptionPane.INFORMATION_MESSAGE, iconic);
            		
        		}
        		else if(type == "Bank Transfer")
        		{
        			ImageIcon iconic = new ImageIcon("C:\\Users\\User\\Desktop\\OOP_IMAGES\\bank.png");
            		JOptionPane.showMessageDialog(null, "","Payemnt",JOptionPane.INFORMATION_MESSAGE, iconic);
            		
        		}
        	
        		Receipt_GUI receipt = new Receipt_GUI(orderID, paymentID);
        		receipt.updateOrder(orderID);
        		receipt.updatePay(paymentID);
        		receipt.setVisible(true);
        		/*
        		Product_1_GUI product = new Product_1_GUI(customerID);
        		product.update(customerID);
         	   product.setVisible(true);
         	   */
 				dispose();
         	
        	}
        	else // No address selected
        	{
        		JOptionPane.showMessageDialog(null, "Please select your shipping address !");
        		
        	}
        	
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Error !");
        }
		
        
    }
	
	private boolean checkCombo()
	{
		
		
		if(RB_ShippingAddress.isSelected())
		{
		
			if(RB_OTHERS.isSelected())
			{
				return false;
			}
			return true;
		}
		else if(RB_OTHERS.isSelected())
		{
			if(RB_ShippingAddress.isSelected())
			{
				return false;
			}
			if(Address.getText().length() != 0)
			{
				return true;
			}
			return false;
		}
		
			
		return false;
		
	}
	
	private int checkText()
	{
		
		if(RB_ShippingAddress.isSelected()) //use customer's address
		{
			return 1;
		}
		else 
		{
			return 2;
		}
		
	}
	
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
		Product_1_2_GUI product = new Product_1_2_GUI(customerID);
		product.update(customerID);
 	   product.setVisible(true);
			dispose();
        
    }

}
