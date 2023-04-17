package avenue;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDButil {


	private static boolean isSuc;
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	//validate
	
	public static boolean validate(String uname, String password) {
			
			try {
				con = ConnectionProvider.getConnection();
				st = con.createStatement();
				String sql = "select * from customerdetails where userName='"+uname+"' and password='"+password+"'";
				rs = st.executeQuery(sql);
				
				if (rs.next()) {
					isSuc = true;
				} else {
					isSuc = false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isSuc;
		}
	
	public static List<Customer> getCustomer(String uName) {
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			
			con = ConnectionProvider.getConnection();
			st = con.createStatement();
			String sql = "select * from customerdetails where userName='"+uName+"'";
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
				String name = rs.getString(1);
				String uname = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String mobno = rs.getString(5);
				String address = rs.getString(6);
				String city = rs.getString(7);
				String state = rs.getString(8);
				String country = rs.getString(9);
				
				Customer cus = new Customer(name,uname,password,email,mobno,address,city,state,country);
				customer.add(cus);
			}
			
		} catch (Exception e) {
			
		}
		
		return customer;	
	}
	
	
	
	
	
	// Insert
	
	public static boolean customerdetails(String name, String uname, String password, String email, String mobno, String address, String city, String state, String country) {
		
		boolean isSuc = false;
		
		
		try {
			con = ConnectionProvider.getConnection();
			st = con.createStatement();
			String sql = "insert into customerdetails values('"+name+"','"+uname+"','"+password+"','"+email+"','"+mobno+"','"+address+"','"+city+"','"+state+"','"+country+"') ";
	
			int resl = st.executeUpdate(sql);
			
			if(resl >0) {
				isSuc = true;
			}
			else {
				isSuc = false;
			}
		}
		
		catch(Exception e) {
			System.out.print(e);
			
			
		}
		
		
		
		
		return isSuc;
	}
}
