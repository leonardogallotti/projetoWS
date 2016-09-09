package persistence;

import java.sql.*;

public class Dao {

	Connection				con;
	PreparedStatement		stmt;
	ResultSet				rs;
	
	
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wsCrude", "root", "le0405");
		
	}
	
	public void close() throws Exception{
		con.close();
	}
	
	
	public static void main(String[] args) {
		try {
			Dao d = new Dao();
			d.open();
			d.close();
			System.out.println("ok");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
