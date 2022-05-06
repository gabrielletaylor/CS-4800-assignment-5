package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements DataBaseConnection{
	@Override
	public Connection getDataBaseConnection() throws ClassNotFoundException, SQLException {
		final String URL = "jdbc:mysql://localhost:3306/authentication";
		final String USER = "mysql";
		final String PWD = "123";
		
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		
		return connection;
	}
}