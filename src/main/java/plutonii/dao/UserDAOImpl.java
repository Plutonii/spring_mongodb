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
		System.out.println("rdgdhrdhdrh");
		System.out.println(user.getId());
		getCurrentSession().update(user);
	}

	public void addUser(User user) throws SQLException {
		getCurrentSession().save(user);
	}

	public void deleteUser(User user) throws SQLException {
		getCurrentSession().delete(user);
	}

	public User getUser(String id) throws SQLException {
		return (User) getCurrentSession().createQuery("from User u where u.id = :id1")
				.setParameter("id1", id).list().get(0);
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		users = getCurrentSession().createCriteria(User.class).list();
		return users;
	}

	public List<User> getSubordinatesUser(String id) throws SQLException {
		return getCurrentSession().createQuery("from User u where u.idHeadUser = :id_head")
				.setParameter("id_head", id).list();
	}

}