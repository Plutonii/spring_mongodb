package plutonii.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plutonii.dao.TokenDAO;
import plutonii.model.UserToken;

import java.sql.SQLException;
import java.sql.Timestamp;

@Service
@Transactional

public class TokenService {
	@Autowired
	private TokenDAO TokenDAO;
	
	public void addToken(String UserID){
		java.util.Date date= new java.util.Date();
		Timestamp expTime = new Timestamp(date.getTime());
		UserToken token = new UserToken();
		token.setUserID(UserID);
		token.setToken(UUID.randomUUID().toString());
		token.setExpTime(expTime);
		System.out.println("before try");
		try {
			TokenDAO.addToken(token);
			System.out.println("after try");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteToken(String UserID){
		try {
			TokenDAO.deleteToken(UserID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateToken(String UserID){
		try {
			TokenDAO.refreshToken(UserID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
