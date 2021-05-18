package com.newewebsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection connection;
	
	public DBConnection (String dbUrl, String username , String password) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root","root");
					
	}
	
	public Connection getConnection() {
		
		return this.connection;
	}
	
	public void colseConnection() throws SQLException {
		 if(this.connection!=null)
			 this.connection.close();
		 		
	}

}
