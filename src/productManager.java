import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class productManager {
	public void insert(Product product)
	{
		 try {
			 	DatabaseConnection db = new DatabaseConnection();
			 	Connection conn = db.getConnection();
	            String sql = "INSERT INTO product(Product_Name,Price,Category,Admin_ID) VALUES (?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	           
	            ps.setString(1, product.getProduct_Name());
	            ps.setDouble(2, product.getPrice());
	            ps.setString(3, product.getCategory());
	            ps.setInt(4, product.getAdmin_ID());
	            ps.executeUpdate();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error now");
	        }
	}
	
	
	
	 public void update(Product product) {
	      
	        
         try {
          
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "UPDATE product SET Product_Name=?,Price=?,Category=?,Admin_ID=? WHERE Product_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProduct_Name());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setInt(4, product.getAdmin_ID());
            ps.setInt(5, product.getProduct_ID());
            ps.executeUpdate();
 
        
            //JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	 
	  public void delete(int id) {
	       try {
	          
	    	   DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "DELETE FROM product WHERE Product_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Deleteddd!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	    }
	  
	  public Product get(int product_ID) {
	        
	        
	         Product product = new Product();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM product WHERE Product_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, product_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                product.setProduct_ID(rs.getInt("Product_ID"));
	                product.setProduct_Name(rs.getString("Product_Name"));
	                product.setPrice(rs.getDouble("Price"));
	                product.setCategory(rs.getString("Category"));
	                product.setAdmin_ID(rs.getInt("Admin_ID"));
	 
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error get");
	        }
	        return product;
	    }
	  
	  
	  public boolean checkProduct(int product_ID) {
	        
	        
	         Product product = new Product();
	        try {
	        	DatabaseConnection db = new DatabaseConnection();
				Connection conn = db.getConnection();
	            String sql = "SELECT * FROM product WHERE Product_ID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, product_ID);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                product.setProduct_ID(rs.getInt("Product_ID"));
	                product.setProduct_Name(rs.getString("Product_Name"));
	                product.setPrice(rs.getDouble("Price"));
	                product.setCategory(rs.getString("Category"));
	                product.setAdmin_ID(rs.getInt("Admin_ID"));
	           	 
	                return true;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            //JOptionPane.showMessageDialog(null, "Error");
	        }
	        return false;
	    }
	  
	  public List<Product> list() {
	      
          List<Product> list = new ArrayList<Product>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Product product = new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setProduct_Name(rs.getString("Product_Name"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategory(rs.getString("Category"));
                product.setAdmin_ID(rs.getInt("Admin_ID"));
           	 
                list.add(product);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
	  
public List<Product> listCat(String category) {
	      
          List<Product> list = new ArrayList<Product>();
        try {
        	DatabaseConnection db = new DatabaseConnection();
			Connection conn = db.getConnection();
            String sql = "SELECT * FROM product where Category=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Product product = new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setProduct_Name(rs.getString("Product_Name"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategory(rs.getString("Category"));
                product.setAdmin_ID(rs.getInt("Admin_ID"));
           	 
                list.add(product);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }




public boolean getProduct(int product_ID, String category) {
    
    
    Product product = new Product();
   try {
   	DatabaseConnection db = new DatabaseConnection();
		Connection conn = db.getConnection();
       String sql = "SELECT * FROM product WHERE Product_ID=? AND Category=?";
       PreparedStatement ps = conn.prepareStatement(sql);
       ps.setInt(1, product_ID);
       ps.setString(2, category);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           product.setProduct_ID(rs.getInt("Product_ID"));
           product.setProduct_Name(rs.getString("Product_Name"));
           product.setPrice(rs.getDouble("Price"));
           product.setCategory(rs.getString("Category"));
           product.setAdmin_ID(rs.getInt("Admin_ID"));
      	 
           return true;

       }
       else 
    	   return false;
       
   } catch (Exception e) {
       e.printStackTrace();
       return false;
       //JOptionPane.showMessageDialog(null, "Error");
   }
   
}

}
