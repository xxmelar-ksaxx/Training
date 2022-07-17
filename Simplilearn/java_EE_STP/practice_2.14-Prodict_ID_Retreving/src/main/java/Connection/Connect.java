package Connection;

import java.sql.*;

public class Connect {

	private static Connection con;
	
	public static Connection getConnection() { 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","jroot","1234");
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return con;
	}



}
