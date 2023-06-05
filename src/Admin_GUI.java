import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Admin_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField insertName;
	private JTextField insertPrice;
	private JTextField updateName;
	private JTextField updatePrice;
	private JTable table;
	private JTextField search;
	private JTextField delete;
	private DefaultTableModel model;
	public static int adminID;
	private JComboBox insertCat;
	private JComboBox updateCat;
	private JTextField updateID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_GUI frame = new Admin_GUI(adminID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void update(int adminID)
	{
		Admin_GUI.adminID = adminID;
	}
	
	/**
	 * Create the frame.
	 */
	public Admin_GUI(int adminID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(176, 196, 222), 1, true));
		panel.setBounds(35, 30, 466, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 74, 142, 44);
		panel.add(lblNewLabel);
		
		JLabel lblCategory = new JLabel("Category          :");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCategory.setBounds(10, 118, 132, 44);
		panel.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price (RM)       :");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrice.setBounds(10, 172, 132, 44);
		panel.add(lblPrice);
		
		insertName = new JTextField();
		insertName.setFont(new Font("Tahoma", Font.BOLD, 17));
		insertName.setBounds(165, 81, 266, 32);
		panel.add(insertName);
		insertName.setColumns(10);

		
		
		insertPrice = new JTextField();
		insertPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		insertPrice.setColumns(10);
		insertPrice.setBounds(165, 179, 266, 32);
		panel.add(insertPrice);
		
		String category[] = {"RACQUET", "SHOES", "SHUTTLECOCK", "OTHERS"};
		
		insertCat = new JComboBox(category);
		insertCat.setBounds(165, 127, 266, 32);
		panel.add(insertCat);
		
		JLabel lblNewLabel_1 = new JLabel("INSERT NEW PRODUCT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(95, 10, 346, 44);
		panel.add(lblNewLabel_1);
		
		JButton btnINSERT = new JButton("INSERT");
		btnINSERT.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnINSERT.setBounds(309, 231, 132, 32);
		panel.add(btnINSERT);
		btnINSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINSERTActionPerformed(evt);
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(176, 196, 222), 1, true));
		panel_1.setBounds(35, 328, 466, 329);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 123, 142, 44);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblCategory_1 = new JLabel("Category          :");
		lblCategory_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCategory_1.setBounds(10, 177, 132, 44);
		panel_1.add(lblCategory_1);
		
		JLabel lblPrice_1 = new JLabel("Price (RM)       :");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrice_1.setBounds(10, 231, 132, 44);
		panel_1.add(lblPrice_1);
		
		updateName = new JTextField();
		updateName.setFont(new Font("Tahoma", Font.BOLD, 17));
		updateName.setColumns(10);
		updateName.setBounds(162, 130, 266, 32);
		panel_1.add(updateName);
		
		updatePrice = new JTextField();
		updatePrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		updatePrice.setColumns(10);
		updatePrice.setBounds(162, 238, 266, 32);
		panel_1.add(updatePrice);
		
		
		
		updateCat = new JComboBox(category);
		updateCat.setBounds(162, 184, 266, 32);
		panel_1.add(updateCat);
		
		JLabel lblNewLabel_1_1 = new JLabel("UPDATE PRODUCT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(138, 10, 266, 44);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(312, 287, 132, 32);
		panel_1.add(btnUpdate);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product ID       :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(10, 69, 142, 44);
		panel_1.add(lblNewLabel_2_1);
		
		updateID = new JTextField();
		updateID.setFont(new Font("Tahoma", Font.BOLD, 17));
		updateID.setColumns(10);
		updateID.setBounds(162, 76, 266, 32);
		panel_1.add(updateID);
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(588, 30, 714, 519);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT TABLE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(255, 10, 179, 51);
		panel_2.add(lblNewLabel_3);
		
		table = new JTable();
		table.setBounds(34, 51, 657, 458);
		
		
		model = new DefaultTableModel();
		
		Object[] column = {"Product ID", "Product Name", "Category", "Price (RM)"};
		model.setColumnIdentifiers(column);
		List <Product> list = null;
		
		productManager ProductManager = new productManager();
		list = ProductManager.list();
		if(list != null)
		{
			Object [] obj = new Object[4];
			obj[0] = "Product ID";
			obj[1] = "Product Name";
			obj[2] = "Category";
			obj[3] = "Price (RM)";
			model.addRow(obj);
			
			for (Product product : list) {
				  Object[] o = new Object[4];
				  o[0] = product.getProduct_ID();
				 
				  o[1] = product.getProduct_Name();
				  o[2] = product.getCategory();
				  o[3] = product.getPrice();
				  
				  
				  model.addRow(o);
				}
			
			table.setModel(model);
		}
		else
		{
			
			table.setModel(model);
		}
		panel_2.add(table);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(135, 206, 235)));
		panel_3.setBounds(557, 559, 366, 156);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SEARCH PRODUCT");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(69, 10, 266, 44);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProductId.setBounds(10, 57, 132, 44);
		panel_3.add(lblProductId);
		
		search = new JTextField();
		search.setFont(new Font("Tahoma", Font.BOLD, 17));
		search.setColumns(10);
		search.setBounds(140, 64, 142, 32);
		panel_3.add(search);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.setBounds(224, 114, 132, 32);
		panel_3.add(btnSearch);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(new Color(135, 206, 235)));
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(936, 559, 366, 156);
		contentPane.add(panel_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DELETE PRODUCT");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(69, 10, 266, 44);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblProductId_1 = new JLabel("Product ID :");
		lblProductId_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProductId_1.setBounds(10, 57, 132, 44);
		panel_3_1.add(lblProductId_1);
		
		delete = new JTextField();
		delete.setFont(new Font("Tahoma", Font.BOLD, 17));
		delete.setColumns(10);
		delete.setBounds(140, 64, 142, 32);
		panel_3_1.add(delete);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(224, 114, 132, 32);
		panel_3_1.add(btnDelete);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGoBack.setBounds(170, 670, 164, 45);
		contentPane.add(btnGoBack);
		
	}
	
	public void deleteAndReset()
	{
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		productManager ProductManager = new productManager();
		List <Product> list = ProductManager.list();
		if(list != null)
		{
			Object [] obj = new Object[4];
			obj[0] = "Product ID";
			obj[1] = "Product Name";
			obj[2] = "Category";
			obj[3] = "Price (RM)";
			model.addRow(obj);
			for (Product product : list) {
				  Object[] o = new Object[4];
				  o[0] = product.getProduct_ID();
				  o[1] = product.getProduct_Name();
				  o[2] = product.getCategory();
				  o[3] = product.getPrice();
				  
			
				  model.addRow(o);
				}
			
			table.setModel(model);
		}
		else
		{
			
			table.setModel(model);
		}
		
	}
	
	private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       LoginGUI login = new LoginGUI();
       login.setVisible(true);
       dispose();
		
        
    }
	
	private void btnINSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
        	Product product = new Product();
        	
        	Object obj = insertCat.getItemAt(insertCat.getSelectedIndex());
    		String type = obj.toString().trim();
        	product.setCategory(type);
        	String name = insertName.getText().trim();
        	product.setProduct_Name(name);
        	
    		double price = Double.parseDouble(insertPrice.getText().trim());
    		product.setPrice(price);
    		product.setAdmin_ID(adminID);
    	
    		productManager ProductManager = new productManager();
    		ProductManager.insert(product);
    		JOptionPane.showMessageDialog(null, "Sucessfully inserted !");
    		deleteAndReset();
        	
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Error ! Please insert all the data");
        }
		
		
        
    }
	
	private boolean checkUpdateName()
	{
		String name = updateName.getText();
		if(name == null || name.trim().equals( "" ))
		{
			return true; // no update name
		}
				
		return false;
		
	}
	
	private boolean checkUpdatePrice()
	{
		try {
			double price = Double.parseDouble(updatePrice.getText().trim());
			return false;
			
		}catch(Exception e)
		{
			return true;
		}
	}
	
	private boolean checkUpdateProductID()
	{
		try {
			int productID = Integer.parseInt(updateID.getText().trim());
			return false;
			
		}catch(Exception e)
		{
			return true;
		}
	}
	
	
	
	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		
		
	boolean testing = checkUpdateProductID();
	if(testing == false)
	{

		 try {
			 
			 Product product = new Product();
			    
		    	productManager ProductManager = new productManager();
		    	int productID = Integer.parseInt(updateID.getText().trim());
		    	boolean checkID = ProductManager.checkProduct(productID);
		    	
		    	Object obj = updateCat.getItemAt(updateCat.getSelectedIndex());
				String type = obj.toString();
			

			 
	    		if(checkID == true) //product ID exists
	    		{
	    			product = ProductManager.get(productID);
	    			
	    			
	    			product.setCategory(type);
	    			
	    			
	    			boolean checkName = checkUpdateName();
	    			if(checkName == false)
	    			{
	    				String name = updateName.getText();
	    				product.setProduct_Name(name);
	    			}
	    			
	    			
	    			boolean checkPrice = checkUpdatePrice();
	    			if(checkPrice == false)
	    			{
	    				double price = Double.parseDouble(updatePrice.getText().trim());
	    				
	    				product.setPrice(price);
	    			}
	    			
	    			
	    			product.setProduct_ID(productID);
		    		
	    			product.setAdmin_ID(adminID);	
	    			
		    		ProductManager.update(product);
		    		JOptionPane.showMessageDialog(null, "Sucessfully updated !");
		    		deleteAndReset();
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "ID not found !");
	    		}
	    		
	        	
	        }catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, "Error !");
	        }
	}
	else // Product ID is empty
	{
		JOptionPane.showMessageDialog(null, "Please insert Product ID !");
	}
	
		
	        
    }
	
	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
		try {
			
			int productID = Integer.parseInt(delete.getText());
			productManager ProductManager = new productManager();
			boolean checkID = ProductManager.checkProduct(productID);
			if(checkID == true)
			{
				ProductManager.delete(productID);
				JOptionPane.showMessageDialog(null, "Sucessfully deleted !");
				deleteAndReset();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID not found !");
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error !");
		}
        
    }
	
	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
		try {
			int productID = Integer.parseInt(search.getText());
			productManager ProductManager = new productManager();
		
			boolean checkID = ProductManager.checkProduct(productID);
			if(checkID == true)
			{
				Product_Admin_GUI show = new Product_Admin_GUI(adminID,productID);
				show.updateAdmin(adminID);
				show.updatePro(productID);
				show.setVisible(true);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID not found !");
			}
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error !");
		}
        
    }
	
	

}
