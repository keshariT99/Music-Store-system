package avenue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDButil {
	
	private static boolean isSuc;
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	
	public static boolean product(String id, String name, String category, String price,String availability) {
		
		boolean isSuc = false;
		
		try {
			con = ConnectionProvider.getConnection();
			st = con.createStatement();
			String sql = "insert into product values('"+id+"','"+name+"','"+category+"','"+price+"','"+availability+"') ";
	
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
	
	
	//update
	
	public static boolean updatecus(String id, String name, String category, String price, String availability) {
		
		try {
			
			con = ConnectionProvider.getConnection();
			st = con.createStatement();
			String sql = "update product set name '"+name+"', category '"+category+"', price '"+price+"', availability '"+availability+"' " +"where id='"+id+"' ";
			int resl = st.executeUpdate(sql);
			
			
			if(resl > 0) {
				isSuc = true;
			}
			else {
				isSuc = false;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuc;


	}

}
