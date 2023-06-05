import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class listManager {
	public void insert(OrderList orderlist)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO order_list(Product_ID,Order_ID,Quantity,Subtotal) VALUES (?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, orderlist.getProduct_ID());
	            ps.setInt(2, orderlist.getOrder_ID());
	        
	            ps.setInt(3, orderlist.getQuantity());
	            ps.setDouble(4, orderlist.getSubtotal());
	            ps.executeUpdate();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	 public void update(OrderList orderlist) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE order_list SET Product_ID=?,Order_ID=?,Quantity=?,Subtotal=? WHERE List_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderlist.getProduct_ID());
            ps.setInt(2, orderlist.getOrder_ID());
          
            ps.setInt(3, orderlist.getQuantity());
            ps.setDouble(4, orderlist.getSubtotal());
            ps.setInt(5, orderlist.getList_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated! listManager");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(OrderList orderlist) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM order_list WHERE List_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, orderlist.getList_ID());
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public void deleteOrderID(int orderID) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM order_list WHERE Order_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, orderID);
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public OrderList get(int list_ID) {
	        
	        
	         OrderList orderlist = new OrderList();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM order_list WHERE List_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, list_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                orderlist.setList_ID(rs.getInt("List_ID"));
	                orderlist.setProduct_ID(rs.getInt("Product_ID"));
	                orderlist.setOrder_ID(rs.getInt("Order_ID"));
	                
	                orderlist.setQuantity(rs.getInt("Quantity"));
	                orderlist.setSubtotal(rs.getDouble("Subtotal"));
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return orderlist;
	    }
	  
	  public List<OrderList> list() {
	      
          List<OrderList> List = new ArrayList<OrderList>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM order_list";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                OrderList orderlist = new OrderList();
                orderlist.setList_ID(rs.getInt("List_ID"));
                orderlist.setProduct_ID(rs.getInt("Product_ID"));
                orderlist.setOrder_ID(rs.getInt("Order_ID"));
                
                orderlist.setQuantity(rs.getInt("Quantity"));
                orderlist.setSubtotal(rs.getDouble("Subtotal"));
                List.add(orderlist);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return List;
  
    }
	  
public List<OrderList> listOrder(int orderID) {
	      
          List<OrderList> List = new ArrayList<OrderList>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM order_list WHERE Order_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                OrderList orderlist = new OrderList();
                orderlist.setList_ID(rs.getInt("List_ID"));
                orderlist.setProduct_ID(rs.getInt("Product_ID"));
                orderlist.setOrder_ID(rs.getInt("Order_ID"));
                
                orderlist.setQuantity(rs.getInt("Quantity"));
                orderlist.setSubtotal(rs.getDouble("Subtotal"));
                List.add(orderlist);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return List;
  
    }
	  
	  

}
