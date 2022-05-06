package model.dataccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnection {
	public Connection getDataBaseConnection() throws ClassNotFoundException, SQLException;
}