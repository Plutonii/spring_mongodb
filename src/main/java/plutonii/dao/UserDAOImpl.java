package plutonii.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import plutonii.dao.UserDAO;
import plutonii.model.User;
//import org.hibernate.Session;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public void changeUser(User user) throws SQLException {
		getCurrentSession().update(user);
	}

	public void addUser(User user) throws SQLException {
		getCurrentSession().save(user);
	}

	public void deleteUser(User user) throws SQLException {
		getCurrentSession().delete(user);
	}

	public User getUser(Integer id) throws SQLException {
		return (User) getCurrentSession().load(User.class, id);
	}

	public List<User> getAllUsers() throws SQLException {
		List users = new ArrayList<User>();
		users = getCurrentSession().createCriteria(User.class).list();
		return users;
	}

}