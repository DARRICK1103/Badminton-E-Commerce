import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class paymentManager {
	public void insert(Payment payment)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO payment(Payment_Type,Total_Price) VALUES (?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, payment.getPayment_Type());
	          
	           ps.setDouble(2, payment.getTotal_Price());
	            ps.executeUpdate();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	          JOptionPane.showMessageDialog(null, "Error PaymentManager");
	        }
	}
	
	 public void update(Payment payment) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE payment SET Payment_Type=?,Total_Price=? WHERE Payment_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, payment.getPayment_Type());
           
            ps.setDouble(2, payment.getTotal_Price());
            ps.setInt(3, payment.getPayment_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(Payment payment) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM payment WHERE Payment_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1,  payment.getPayment_ID());
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public Payment get(int payment_ID) {
	        
	        
	         Payment payment = new Payment();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM payment WHERE Payment_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, payment_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	payment.setPayment_ID(rs.getInt("Payment_ID"));
	            	payment.setPayment_Type(rs.getString("Payment_Type"));
	            	
	                payment.setTotal_Price(rs.getDouble("Total_Price"));
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return payment;
	    }
	  
	  public List<Payment> list() {
	      
          List<Payment> list = new ArrayList<Payment>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM payment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Payment payment = new Payment();
                payment.setPayment_ID(rs.getInt("Payment_ID"));
            	payment.setPayment_Type(rs.getString("Payment_Type"));
            	
            	 payment.setTotal_Price(rs.getDouble("Total_Price"));
              
                list.add(payment);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error PaymentManager");
        }
        return list;
  
    }
	  
	  public int getLatestID()
	  {
		  int paymentID = 0;
		  try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT MAX(Payment_ID) FROM payment";
	            PreparedStatement ps = conn.prepareStatement(sql);
	           
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	paymentID = rs.getInt("MAX(Payment_ID)");
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
	        return paymentID;
	    
	  }
	  
}
