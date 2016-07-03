package plutonii.dao;

import java.sql.SQLException;

import plutonii.model.UserToken;

public interface TokenDAO {
	
	void addToken(UserToken token) throws SQLException;
	
	void deleteToken(String UserID) throws SQLException;
	
	void refreshToken(String UserID) throws SQLException;

}
