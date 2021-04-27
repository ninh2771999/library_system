/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_Classes;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author LaptopAZ.vn
 */
public class DB {
   private  static String db = "java_library_system";
	private static String url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		try {
			// tìm và nạp driver: (java8 không cần)
			Class.forName("com.mysql.jdbc.Driver");
			// tạo kết nối giữa java vs hqt csdl
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
