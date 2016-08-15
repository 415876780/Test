package com.local.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "jack";
	private static Connection conn = null;
	
	private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();
	
	public static Connection getConnection(){
		Connection conn = connContainer.get();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;		
		
	}
	
	public static void closeConnection(){
		Connection conn = connContainer.get();
		try {
			if(conn!= null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
