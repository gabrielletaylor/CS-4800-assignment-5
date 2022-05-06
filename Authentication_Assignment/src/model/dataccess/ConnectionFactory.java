package model.dataccess;

public class ConnectionFactory {
	public DataBaseConnection getConnection(String dataBase) {
		if (dataBase == null) {
			return null;
		}
		
		if (dataBase.equalsIgnoreCase("postgres")) {
			return new PostgresConnection();
		} else if (dataBase.equalsIgnoreCase("mysql")) {
			return new MySqlConnection();
		}
		
		return null;
	}
}