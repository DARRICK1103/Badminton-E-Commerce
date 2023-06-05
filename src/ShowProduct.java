import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ShowProduct extends JFrame {

	private JPanel contentPane;

	private JTable table;
	private DefaultTableModel model;
	private JTable table_1;
	public JTextField PRODUCT_ID;
	
	public static int customerID;
	public static int selection;
	

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try {
				
					
					ShowProduct frame = new ShowProduct(selection, customerID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error Show_GUI");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void updateCus(int CustomerID)
	{
		ShowProduct.customerID = CustomerID;
		
	}
	public void updateSe(int selection)
	{
		ShowProduct.selection = selection;
	}

	
	
	
	public ShowProduct(int selection, int CustomerID) {
		//Product_1_GUI product = new Product_1_GUI();
		//Product_1_GUI product = new Product_1_GUI();
		//selection = product.getSleepSense();
		
		//SetSelection(product.sleepSense);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 141, 483, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		Object[] column = {"Product ID", "Product Name", "Price (RM)"};
		model.setColumnIdentifiers(column);
		productManager ProductManager = new productManager();
		List <Product> list = null;
		String category;
		if(selection == 1)
		{
			list = ProductManager.listCat("OTHERS");
			category = "OTHERS";
		}
		else if (selection == 2)
		{
			list = ProductManager.listCat("SHUTTLECOCKS");
			category = "SHUTTLECOCKS";
		}
		else if (selection == 3)
		{
			list = ProductManager.listCat("SHOES");
			category = "SHOES";
		}
		else //4
		{
			list = ProductManager.listCat("RACQUET");
			category = "RACQUET";
		}

	
		JLabel lblNewLabel = new JLabel(category);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(14, 21, 507, 94);
		contentPane.add(lblNewLabel);
		
		JButton btnGO_BACK = new JButton("GO BACK");
		btnGO_BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGO_BACKActionPerformed(evt);
            }
        });
		
		btnGO_BACK.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnGO_BACK.setBounds(38, 602, 223, 63);
		contentPane.add(btnGO_BACK);
		
		JButton btnSEARCH = new JButton("SEARCH");
		btnSEARCH.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSEARCH.setBounds(619, 602, 223, 63);
		contentPane.add(btnSEARCH);
		btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            	 
              
                boolean test = btnSEARCHActionPerformed(evt);
                
                if(test == true)
                {
                	int productID = Integer.parseInt(PRODUCT_ID.getText());
                	productManager ProductManager = new productManager();
                	boolean product = ProductManager.getProduct(productID, category);
                	if(product==true)
                	{
                		
                		openNext();
                	}
                	 else
                     {
                     	Error();
                     }
                	
                }
               
         
                
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(619, 237, 242, 94);
		contentPane.add(lblNewLabel_1);
		
		PRODUCT_ID = new JTextField();
		PRODUCT_ID.setFont(new Font("Tahoma", Font.PLAIN, 27));
		PRODUCT_ID.setBounds(640, 316, 125, 50);
		contentPane.add(PRODUCT_ID);
		PRODUCT_ID.setColumns(10);
		
		
		
		
		
		if(list != null)
		{
			for (Product product : list) {
				  Object[] o = new Object[3];
				  o[0] = product.getProduct_ID();
				  o[1] = product.getProduct_Name();
				  o[2] = product.getPrice();
				
				  model.addRow(o);
				}
			table.setModel(model);
		}
		else
		{
			table.setModel(model);
		}
		
	
		
		
	}
	
	
	private void openNext()
	{
		int productID = Integer.parseInt(PRODUCT_ID.getText());
	
		try {
			Order_3_GUI order = new Order_3_GUI(productID, customerID); 
			order.updatePro(productID);
			order.updateCus(customerID);
		
			order.setVisible(true);
			dispose();
			/*
			(productID, customerID)
			 
			order.updatePro(productID);
			order.updateCus(customerID);
	        order.setVisible(true);
	        dispose();
	        */
			
		}catch (Exception e) {
            e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Error call order");
        }
	 	
        
	}
	
	private void btnGO_BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Product_1_GUI product = new Product_1_GUI(customerID);
        product.setVisible(true);
		dispose();
        
    }
	
	private void Error()
	{
		JOptionPane.showMessageDialog(this, "Error !!! Please Make Sure That You Are Entering ID Correctly !!!");
	}
	
	private boolean btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		  
		
          
          String check = PRODUCT_ID.getText();
  		
  		int Value = 0;
  		try {
  		    Value = Integer.parseInt(check);
  		    return true;
  		} catch (NumberFormatException e) {
  			JOptionPane.showMessageDialog(this, "Error !!! Please Make Sure That You Are Entering Integer Only !!!");
  			return false;
  		}
          
        
    }
}
