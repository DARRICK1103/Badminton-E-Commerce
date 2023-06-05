import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class adminManager {
	public void insert(Admin admin)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO admin(Admin_Name,Admin_Password,Admin_Username) VALUES (?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, admin.getAdmin_Name());
	            ps.setString(2, admin.getAdmin_Password());
	            ps.setString(3, admin.getAdmin_Username());
	            ps.executeUpdate();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	 public void update(Admin admin) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE admin SET Admin_Name=?,Admin_Password=?,Admin_Username=? WHERE Admin_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getAdmin_Name());
            ps.setString(2, admin.getAdmin_Password());
            ps.setString(3, admin.getAdmin_Username());
            ps.setInt(4,admin.getAdmin_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(Admin admin) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM admin  WHERE Admin_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, admin.getAdmin_ID());
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public Admin get(int admin_ID) {
	        
	        
	         Admin admin = new Admin();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM admin WHERE Admin_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, admin_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                
	                admin.setAdmin_ID(rs.getInt("Admin_ID"));
	                admin.setAdmin_Name(rs.getString("Admin_Name"));
	                admin.setAdmin_Password(rs.getString("Admin_Password"));
	                admin.setAdmin_Username(rs.getString("Admin_Username"));
	              
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return admin;
	    }
	  
	  
	  public boolean checkAdminUsername(String username) {
	        
	        
	         Admin admin = new Admin();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM admin WHERE Admin_Username=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                
	                admin.setAdmin_ID(rs.getInt("Admin_ID"));
	                admin.setAdmin_Name(rs.getString("Admin_Name"));
	                admin.setAdmin_Password(rs.getString("Admin_Password"));
	                admin.setAdmin_Username(rs.getString("Admin_Username"));
	              
	                return true;
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return false;
	    }
	  
	  public int getLogin(String username, String password) {
	        
	        
	         Admin admin = new Admin();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM admin WHERE Admin_Username=? AND Admin_Password=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                
	                admin.setAdmin_ID(rs.getInt("Admin_ID"));
	                admin.setAdmin_Name(rs.getString("Admin_Name"));
	                admin.setAdmin_Password(rs.getString("Admin_Password"));
	                admin.setAdmin_Username(rs.getString("Admin_Username"));
	                return admin.getAdmin_ID();
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return 0;
	    }
	  
	  
	  public List<Admin> list() {
	      
          List<Admin> list = new ArrayList<Admin>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM admin ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Admin admin = new Admin();
                admin.setAdmin_Username(rs.getString("Admin_Username"));
                admin.setAdmin_Name(rs.getString("Admin_Name"));
               admin.setAdmin_Password(rs.getString("Admin_Password"));
               admin.setAdmin_ID(rs.getInt("Admin_ID"));
 
                list.add(admin);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
	 

}
