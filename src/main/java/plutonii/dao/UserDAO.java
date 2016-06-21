package plutonii.dao;

import java.sql.SQLException;
import java.util.List;

import plutonii.model.User;

public interface UserDAO {
	public void changeUser(User user) throws SQLException;
	public void addUser(User user) throws SQLException;
	public void deleteUser(User user) throws SQLException;
	public User getUser(Integer id) throws SQLException;
	public List<User> getAllUsers() throws SQLException;
}