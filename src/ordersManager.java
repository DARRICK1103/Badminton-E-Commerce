import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ordersManager {
	public void insert(Order order)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO orders(Payment_ID,Customer_ID,Ship_Address,ORDER_DATE,Status) VALUES (?,?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, order.getPayment_ID());
	            ps.setInt(2, order.getCustomer_ID());
	            ps.setString(3, order.getShip_Address());
	            ps.setString(4, order.getORDER_DATE());
	            ps.setInt(5, order.getStatus());
	   
	            ps.executeUpdate();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	          JOptionPane.showMessageDialog(null, "Error OrderManager");
	        }
	}
	
	 public void update(Order order) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE orders SET Payment_ID=?,Customer_ID=?,Status=?,Ship_Address=?,ORDER_DATE=? WHERE Order_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, order.getPayment_ID());
            ps.setInt(2, order.getCustomer_ID());
            ps.setInt(3, order.getStatus());
            ps.setString(4, order.getShip_Address());
            ps.setString(5, order.getORDER_DATE());
            ps.setInt(6, order.getOrder_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(Order order) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM orders WHERE Order_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, order.getOrder_ID());
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public Order get(int order_ID) {
	        
	        
	         Order order = new Order();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM orders WHERE Order_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, order_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	order.setOrder_ID(rs.getInt("Order_ID"));
	            	order.setPayment_ID(rs.getInt("Payment_ID"));
	            	order.setCustomer_ID(rs.getInt("Customer_ID"));
	            	order.setStatus(rs.getInt("Status"));
	            	order.setShip_Address(rs.getString("Ship_Address"));
	            	order.setORDER_DATE(rs.getString("ORDER_DATE"));
	              
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
	        return order;
	    }
	  
	  public List<Order> list() {
	      
          List<Order> list = new ArrayList<Order>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM orders";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Order order = new Order();
                order.setOrder_ID(rs.getInt("Order_ID"));
            	order.setPayment_ID(rs.getInt("Payment_ID"));
            	order.setCustomer_ID(rs.getInt("Customer_ID"));
            	order.setStatus(rs.getInt("Status"));
            	order.setShip_Address(rs.getString("Ship_Address"));
            	order.setORDER_DATE(rs.getString("ORDER_DATE"));
                list.add(order);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
	  public int getLatestID()
	  {
		  int orderID = 0;
		  try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT MAX(Order_ID) FROM orders";
	            PreparedStatement ps = conn.prepareStatement(sql);
	           
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	orderID = rs.getInt("MAX(Order_ID)");
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
	        return orderID;
	    
	  }
	  
	  

}
