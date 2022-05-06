package model.dataccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {
	private static LoginDataAccess instance;
	
	private LoginDataAccess() {
		
	}
	
	public static LoginDataAccess getInstance() {
		if (instance == null) {
			instance = new LoginDataAccess();
		}
		return instance;
	}
	
	public boolean verifyCredentials() throws ClassNotFoundException, SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		DataBaseConnection connection = connectionFactory.getConnection("postgres");
				
		final PreparedStatement stmt = connection.getDataBaseConnection().prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, User.getInstance().getUserName());
		stmt.setString(2, User.getInstance().getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
	}
}



//public class LoginDataAccess {
//
//	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {
//
//		final String URL = "jdbc:postgresql://localhost:5432/authentication";
//
//		final String USER = "postgres";
//
//		final String PWD = "123";
//
//		Class.forName("org.postgresql.Driver");
//		Connection conection = DriverManager.getConnection(URL, USER, PWD);
//
//		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
//
//		stmt.setString(1, user.getUserName());
//		stmt.setString(2, user.getPassword());
//
//		ResultSet rs = stmt.executeQuery();
//
//		return rs.next();
//		
//	}
//
//}

