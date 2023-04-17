package avenue;

import java.sql.*;


public class ConnectionProvider {
	
	private static String url = "jdbc:mysql://localhost:3306/musicstore";
	private static String userName = "root";
	private static String pwd = "MWkgbt5280*";
	private static Connection con;
	
	

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url,userName,pwd);
			
		}
		catch(Exception e) {
			System.out.print(e);
			
			
		}
		return con;
	}

}
