package plutonii.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import plutonii.dao.UserDAO;
import plutonii.model.User;

@Service
@Transactional
public class UserService{

	@Autowired
    private UserDAO userDAO;

	public void addUser(User user) {
		try {
			userDAO.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) {
		try {
			userDAO.deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void changeUser(User user) {
		try {
			userDAO.changeUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User getUser(String id) {
		try {
			return userDAO.getUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> getAllUsers() {
		try {
			return userDAO.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> getSubordinatesUser(String id) {
		try {
			return userDAO.getSubordinatesUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
