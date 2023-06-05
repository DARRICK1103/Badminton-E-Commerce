import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class customerManager {
	public void insert(Customer customer)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO customer(Customer_Name,Customer_IC,Customer_Address,Customer_Password,Customer_Username) VALUES (?,?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, customer.getCustomer_Name());
	            ps.setString(2, customer.getCustomer_IC());
	            ps.setString(3, customer.getCustomer_Address());
	            ps.setString(4, customer.getCustomer_Password());
	            ps.setString(5, customer.getCustomer_Username());
	            ps.executeUpdate();       
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	 public void update(Customer customer) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE customer SET Customer_Name=?,Customer_IC=?,Customer_Address=?,Customer_Password=?,Customer_Username=? WHERE Customer_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomer_Name());
            ps.setString(2, customer.getCustomer_IC());
            ps.setString(3, customer.getCustomer_Address());
            ps.setString(4, customer.getCustomer_Password());
            ps.setString(5, customer.getCustomer_Username());
            ps.setInt(6, customer.getCustomer_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(Customer customer) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM customer WHERE Customer_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, customer.getCustomer_ID());
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public Customer get(int customer_ID) {
	        
	        
	         Customer customer = new Customer();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM customer WHERE Customer_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, customer_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                customer.setCustomer_ID(rs.getInt("Customer_ID"));
	                customer.setCustomer_Name(rs.getString("Customer_Name"));
	                customer.setCustomer_IC(rs.getString("Customer_IC"));
	                customer.setCustomer_Address(rs.getString("Customer_Address"));
	                customer.setCustomer_Password(rs.getString("Customer_Password"));
	                customer.setCustomer_Username(rs.getString("Customer_Username"));         
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return customer;
	    }
	  
	  
	  public boolean checkUsername(String Username) {
	        
	        
	         Customer customer = new Customer();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM customer WHERE Customer_Username=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, Username);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                customer.setCustomer_ID(rs.getInt("Customer_ID"));
	                customer.setCustomer_Name(rs.getString("Customer_Name"));
	                customer.setCustomer_IC(rs.getString("Customer_IC"));
	                customer.setCustomer_Address(rs.getString("Customer_Address"));
	                customer.setCustomer_Password(rs.getString("Customer_Password"));
	                customer.setCustomer_Username(rs.getString("Customer_Username"));  
	                return true;
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return false;
	    }
	  
	  public int getLogin(String username, String password) {
	        
	        
	         Customer customer = new Customer();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM customer WHERE Customer_Username=? AND Customer_Password=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                customer.setCustomer_ID(rs.getInt("Customer_ID"));
	                customer.setCustomer_Name(rs.getString("Customer_Name"));
	                customer.setCustomer_IC(rs.getString("Customer_IC"));
	                customer.setCustomer_Address(rs.getString("Customer_Address"));
	                customer.setCustomer_Password(rs.getString("Customer_Password"));
	                customer.setCustomer_Username(rs.getString("Customer_Username")); 
	                return customer.getCustomer_ID();
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
	        return 0;
	    }
	  
	  public List<Customer> list() {
	      
          List<Customer> list = new ArrayList<Customer>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Customer customer = new Customer();
                customer.setCustomer_ID(rs.getInt("Customer_ID"));
                customer.setCustomer_Name(rs.getString("Customer_Name"));
                customer.setCustomer_IC(rs.getString("Customer_IC"));
                customer.setCustomer_Address(rs.getString("Customer_Address"));
                customer.setCustomer_Password(rs.getString("Customer_Password"));
                customer.setCustomer_Username(rs.getString("Customer_Username"));         
 
                list.add(customer);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }

}
