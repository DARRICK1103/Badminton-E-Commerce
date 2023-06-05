import java.sql.*;
public class DatabaseConnection {

	String driver;
	String dbName;
	String connectionURL;
	String username;
	String password;
	Connection conn;
	
	public DatabaseConnection()
	{
		driver = "com.mysql.cj.jdbc.Driver";
		connectionURL = "jdbc:mysql://localhost:3306/";
		dbName = "badminton_store";
		username = "root";
		password = "password123";
	}

	public Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(connectionURL+dbName,username,password);
		return connection;
	}
	/*
	public static void main(String[] args) {
		DatabaseConnection db = new DatabaseConnection();
		
		try {
			Connection conn = db.getConnection();
			System.out.println("Database successfully connected!\n");
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
		
		
	
	
