import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class TablePurchase_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	/**
	 * Launch the application.
	 */
	
	public static int productID;
	public static int quantity;
	public static int customerID;
	public static int paymentID;
	public static int orderID;
	private JButton btnAdd;
	private JButton btnCheckout;

	private boolean check;
	private JLabel lblNewLabel_1;
	private JTextField textDELETE_OrderNO;
	private JButton btnDelete;
	private JLabel lblNewLabel_2;
	private JTextField textUPDATE_no;
	private JButton btnUpdate;
	private JLabel lblNewLabel_3;
	private JTextField textQuantity;
	
	private List <OrderList> list;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel_8;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablePurchase_GUI frame = new TablePurchase_GUI(productID, quantity, customerID, paymentID, orderID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public void updateProductID (int productID)
	{
		TablePurchase_GUI.productID = productID;
		
	}
	public void updateQuantity(int quantity)
	{
		TablePurchase_GUI.quantity = quantity;
	}
	
	public void updateCustomer(int customerID)
	{
		TablePurchase_GUI.customerID = customerID;
	}
	
	public void updatePayment(int paymentID)
	{
		TablePurchase_GUI.paymentID = paymentID;
	}
	
	public void updateOrder(int orderID)
	{
		TablePurchase_GUI.orderID = orderID;
	}
	/**
	 * Create the frame.
	 */
	public TablePurchase_GUI(int productID, int quantity, int customerID, int paymentID, int orderID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 115, 503, 451);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("ADD MORE ");
		btnAdd.setBounds(84, 587, 202, 65);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
	
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
		contentPane.add(btnAdd);
		
		btnCheckout = new JButton("CHECK OUT");
		btnCheckout.setBounds(633, 587, 202, 65);
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
		contentPane.add(btnCheckout);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(28, 10, 503, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SHOPPING CART");
		lblNewLabel.setBounds(76, 0, 312, 81);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(559, 10, 267, 306);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel(" LIST NO :");
		lblNewLabel_2.setBounds(27, 99, 73, 65);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_3 = new JLabel("QUANTITY :");
		lblNewLabel_3.setBounds(14, 156, 86, 65);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textUPDATE_no = new JTextField();
		textUPDATE_no.setBounds(124, 108, 116, 41);
		panel_2.add(textUPDATE_no);
		textUPDATE_no.setFont(new Font("Tahoma", Font.BOLD, 14));
		textUPDATE_no.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(124, 245, 116, 50);
		panel_2.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBackground(new Color(105, 105, 105));
		
		textQuantity = new JTextField();
		textQuantity.setBounds(124, 173, 116, 41);
		panel_2.add(textQuantity);
		textQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textQuantity.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(40, 24, 171, 65);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_4 = new JLabel("UPDATE LIST");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(21, 10, 122, 55);
		panel_3.add(lblNewLabel_4);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(559, 344, 267, 222);
		contentPane.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(47, 10, 171, 57);
		panel_5.add(panel_6);
		
		lblNewLabel_8 = new JLabel("DELETE LIST");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(28, 0, 122, 55);
		panel_6.add(lblNewLabel_8);
		
		lblNewLabel_1 = new JLabel("LIDT NO :");
		lblNewLabel_1.setBounds(37, 77, 88, 57);
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textDELETE_OrderNO = new JTextField();
		textDELETE_OrderNO.setBounds(126, 87, 122, 38);
		panel_5.add(textDELETE_OrderNO);
		textDELETE_OrderNO.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDELETE_OrderNO.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(126, 155, 116, 47);
		panel_5.add(btnDelete);
		btnDelete.setBackground(new Color(135, 206, 235));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
		
		
		
		model = new DefaultTableModel();
		Object[] column = {"List No", "Product Name", "Quantity", "Subtotal (RM)"};
		model.setColumnIdentifiers(column);
		
		list = null;
		listManager ListManager = new listManager();
		list = ListManager.listOrder(orderID);
		productManager ProductManager = new productManager();
		DecimalFormat df = new DecimalFormat("0.00");
		if(list != null)
		{
			int num = 1;
			for (OrderList orderlist : list) {
				  Object[] o = new Object[4];
				  o[0] = num;
				  Product product = ProductManager.get(orderlist.getProduct_ID());
				  o[1] = product.getProduct_Name();
				  o[2] = orderlist.getQuantity();
				  o[3] = df.format(orderlist.getSubtotal());
				  num++;
				  model.addRow(o);
				}
			check = true; // list not null
			table.setModel(model);
		}
		else
		{
			check = false;
			table.setModel(model);
		}
		
	}
	
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		
		//listManager ListManager = new listManager();
		
		Product_1_2_GUI product = new Product_1_2_GUI(customerID);
		product.update(customerID);
        product.setVisible(true);
		dispose();
		/*
		if(check == true)  // No need create new order_ID
		{
			Product_1_2_GUI product = new Product_1_2_GUI(customerID);
			product.update(customerID);
	        product.setVisible(true);
			dispose();
		}
		else
		{
			  Product_1_GUI product = new Product_1_GUI(customerID);
			  product.update(customerID);
		        product.setVisible(true);
				dispose();
		}
        */
        
    }
	
	public boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
	
	private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		
        boolean checkEmpty = isEmpty(table);
        if(checkEmpty == true)
        {
        	JOptionPane.showMessageDialog(this, "Current shopping cart is empty !");
        	Product_1_GUI product = new Product_1_GUI(customerID);
        	product.update(customerID);
        	   product.setVisible(true);
				dispose();
        	
        	
        }
        else
        {
        	PAY_GUI payment = new PAY_GUI(orderID, customerID, paymentID);
        	payment.updateOrder(orderID);
        	payment.updateCus(customerID);
        	payment.updatePay(paymentID);
        	payment.setVisible(true);
        	dispose();
        }
        
    }
	
	private boolean checkDeleteID() //Format
	{
		String check = textDELETE_OrderNO.getText();
		int Value = 0;
  		try {
  		    Value = Integer.parseInt(check.trim());
  		    return true;
  		} catch (NumberFormatException e) {
  			JOptionPane.showMessageDialog(this, "Error !!! Please Make Sure That You Are Entering Integer Only !!!");
  			return false;
  		}
	}
	
	private boolean checkIDExistUpdate() //return true if Id exist at table
	{
		try {
			int num = table.getRowCount();
			String No = textUPDATE_no.getText();
			int no = Integer.parseInt(No.trim());
			if(no <= num && no >0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "checkIDEXist function");
		}
		
		return false;
		
	}
	
	
	private boolean checkIDExistDelete() //return true if Id exist at table
	{
		try {
			int num = table.getRowCount();
			String No = textDELETE_OrderNO.getText();
			int no = Integer.parseInt(No.trim());
			if(no <= num && no >0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "checkIDEXist function");
		}
		
		return false;
		
	}
	

	private int findRow(int orderlistID)
	{
		int row = 0;
		try {
			int rows = table.getRowCount();
			for(int i = 0; i<rows;i++)
			{
				Object obj = table.getValueAt(i, 1);
				Object x = (Integer)orderlistID;  
				boolean test = obj.equals(x);
				if(test == true)
				{
					return i;
				}
			}
			
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Row function");
		}
		
		
		return row;
	}
	
	public void deleteAndReset()
	{
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		productManager ProductManager = new productManager();
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
				  
				  num++;
				  model.addRow(o);
				}
			check = true; // list not null
			table.setModel(model);
		}
		else
		{
			check = false;
			table.setModel(model);
		}
		
	}
	
	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

  		
		
		try {
			boolean checkID = checkDeleteID(); //format
	  		
	  		
			
			
			boolean checkEmpty = isEmpty(table);
	        
	        boolean checkIDExist = checkIDExistDelete();
	        
	        if(checkID == true && checkEmpty == false && checkIDExist == true)
	        {
	        	int row = Integer.parseInt(textDELETE_OrderNO.getText().trim());
				row-=1;
	        	int orderlistID = list.get(row).getList_ID();
	        
	        	list.remove(row);
	        	listManager ListManager = new listManager();
	        	OrderList orderlist = ListManager.get(orderlistID);
	        	ListManager.delete(orderlist);
	        	
	        	
	        	deleteAndReset();
	        	
	        	JOptionPane.showMessageDialog(null, "Selected list deleted successfully");
	        	
	        }
	        else if(checkEmpty == true)
	        {
	        	JOptionPane.showMessageDialog(null, "The list is empty now.");
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "List Number not found");
	        }
	      
		}catch(Exception e)
		{
			int orderlistID = list.get(0).getOrder_ID();
			listManager ListManager = new listManager();
        	OrderList orderlist = ListManager.get(orderlistID);
        	ListManager.delete(orderlist);
			JOptionPane.showMessageDialog(null, "Error");
			Product_1_2_GUI product = new Product_1_2_GUI(customerID);
			product.update(customerID);
			   product.setVisible(true);
						dispose();
		        	
			
		}
  		
        
		
    }
	
	private boolean checkUpdateID() //Format
	{
		String check1 = textUPDATE_no.getText();
		String check2 = textQuantity.getText();
		int Value1 = 0, Value2 =0;
  		try {
  		    Value1 = Integer.parseInt(check1.trim());
  		    Value2 = Integer.parseInt(check2.trim());
  		    return true;
  		} catch (NumberFormatException e) {
  			JOptionPane.showMessageDialog(this, "Error !!! Please Make Sure That You Are Entering Integer Only !!!");
  			return false;
  		}
	}
	
	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		try {
			boolean checkUpdate = checkUpdateID(); //check format
			int row = Integer.parseInt(textUPDATE_no.getText().trim());
			row-=1;
			int quantity = Integer.parseInt(textQuantity.getText().trim());
			
			
			
			boolean checkExist = checkIDExistUpdate();
			
	        if(checkUpdate == true && checkExist == true)
	        {
	        	
			
	        	int orderlistID = list.get(row).getList_ID();
	        	listManager ListManager = new listManager();
	        	OrderList orderlist = ListManager.get(orderlistID);
	        	orderlist.setQuantity(quantity);
	        	productManager ProductManager = new productManager();
	        	Product product = ProductManager.get(orderlist.getProduct_ID());
	        	double subtotal = quantity*product.getPrice();
	        	orderlist.setSubtotal(subtotal);
	        	ListManager.update(orderlist);
	        	
	        	model.setValueAt(quantity, row, 2);
	        	model.setValueAt(subtotal, row, 3);
	        	 
	        	 
	        	JOptionPane.showMessageDialog(null, "LIST UPDATED");
	        }
		}catch(Exception e)
		{
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error UPDATE");
		}
		
        
    }

}
