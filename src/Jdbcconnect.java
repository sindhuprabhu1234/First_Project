import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbcconnect {

public static void main(String[] args) {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
		String sql="Select * from employees";
		PreparedStatement prepare = con.prepareStatement(sql);
		ResultSet query = prepare.executeQuery();
		while(query.next()) {
			
			String firstname = query.getString("first_name");
			String lastname = query.getString("last_name");
			System.out.println(firstname);
			System.out.println(lastname);
			
				}
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	
}
	
}
