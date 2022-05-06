package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {
	private static LoginBusiness instance;
	private String userName;
	private String password;
	
	private LoginBusiness() {
		
	}
	
	public static LoginBusiness getInstance() {
		if (instance == null) {
			instance = new LoginBusiness();
		}
		return instance;
	}
	
	public boolean verifyCredentials() throws ClassNotFoundException, SQLException {
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		} 
		
		User.getInstance().setUserName(this.userName);
		User.getInstance().setPassword(this.password);
		LoginDataAccess loginDataAccess = LoginDataAccess.getInstance();
		
		if (loginDataAccess.verifyCredentials()) {
			return true;
		} else {
			throw new MessageException("Incorrect credentials.");
		}
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}