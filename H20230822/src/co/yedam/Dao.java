package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	
	private static Connection conn;
	
	public static Connection conn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
