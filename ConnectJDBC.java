import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {
	private final static String url = "jdbc:postgresql://localhost:5432/postgres";
	private final static String user = "postgres";
	private final static String password = "1089";
	
	public static Connection connect() {
		try {
			return DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectJDBC.connect();
		String sql = "SELECT * FROM bill";
		try {
			Statement statment = conn.createStatement();
			ResultSet rs = statment.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("bill_id");
				String title = rs.getString("bill_title");
				
				System.out.println(id + " " + title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null)
				conn.close();
		}
		
	}
}
