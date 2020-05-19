import java.sql.*;

public class SqliteConnection {
	
	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:Demo.sqlite");
	          System.out.println("Connection to SQLite has been established.");

			 return conn;
			
		} catch (Exception e) {
			System.out.println(e);
			  return null;
		}
	}

}
