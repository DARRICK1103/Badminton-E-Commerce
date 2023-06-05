import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Receipt_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private static int orderID;
	private static int paymentID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt_GUI frame = new Receipt_GUI(orderID, paymentID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updateOrder(int orderID)
	{
		Receipt_GUI.orderID = orderID;
	}
	
	public void updatePay(int paymentID)
	{
		Receipt_GUI.paymentID = paymentID;
	}

	/**
	 * Create the frame.
	 */
	public Receipt_GUI(int orderID, int paymentID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(-24, 526, 1312, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(977, 88, 194, 52);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Money Receipt");
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 34));
		lblNewLabel.setBounds(29, 10, 248, 125);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 112, 545, 355);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		listManager ListManager = new listManager();
		List <OrderList> list = ListManager.listOrder(orderID);
		productManager ProductManager = new productManager();
		double total = 0;
		
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
		
		paymentManager PaymentManager = new paymentManager();
		Payment payment = PaymentManager.get(paymentID);
		String method = payment.getPayment_Type();
		JLabel lblNewLabel_1 = new JLabel("Payment Method :  " + method);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(650, 181, 609, 49);
		contentPane.add(lblNewLabel_1);
		
		ordersManager OrderManager = new ordersManager();
		Order order = OrderManager.get(orderID);
		String address = order.getShip_Address();
		JLabel lblNewLabel_1_1 = new JLabel("Shipping Address :  " + address);
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(650, 265, 609, 162);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel total1 = new JLabel("Total: RM " + total);
		total1.setFont(new Font("Tahoma", Font.BOLD, 18));
		total1.setBounds(36, 477, 517, 49);
		contentPane.add(total1);
	}
	


	
private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
	JOptionPane.showMessageDialog(null, "Done Payment !");
	ordersManager OrderManager = new ordersManager();
	Order order = OrderManager.get(orderID);
	customerManager CustomerManager = new customerManager();
	Customer customer = CustomerManager.get(order.getCustomer_ID());
	paymentManager PaymentManager = new paymentManager();
	Payment payment = PaymentManager.get(paymentID);
	String file = "Receipt_" + paymentID +".txt";
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
		  writer.write("PyamentID: " + payment.getPayment_ID());
		  writer.newLine();
		  writer.newLine();
		
		  writer.write("CustomerID: " + order.getCustomer_ID());
		  writer.newLine();
		  writer.newLine();
		  writer.write("Customer Name: " + customer.getCustomer_Name());
		  writer.newLine();
		  writer.newLine();
		  writer.write("Shipping Address : " + order.getShip_Address());
		  writer.newLine();
		  writer.newLine();
		  
		  listManager ListManager = new listManager();
			List <OrderList> list = ListManager.listOrder(orderID);
			productManager ProductManager = new productManager();
			double total = 0;
			for(OrderList List:list)
			{
				total += List.getSubtotal();
				 writer.newLine();
				  Product product = ProductManager.get(List.getProduct_ID());
				  writer.write("Product Name:  " + product.getProduct_Name());
				  writer.newLine();
				  writer.write("Quantity:  " + List.getQuantity());
				  writer.newLine();
				  writer.write("Subtotal:  " + List.getSubtotal());
				  writer.newLine();
			}
			writer.newLine();
			writer.write("Total: RM " + total);
			writer.newLine();
		  
			writer.close(); 
		}
		catch(IOException ex){
		  ex.printStackTrace();
		}
	
	
	
			dispose();
        
    }
}
