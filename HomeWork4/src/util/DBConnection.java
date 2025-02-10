package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DBConnection.getConnection());
	}
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/consoleshop";
		String user = "root";
		String password = "1234";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
