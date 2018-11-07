package j2eeapp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConfig {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
