package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;


public class StudentDao {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/xk?useUnicode=true&amp;characterEncoding=utf-8";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}



}
