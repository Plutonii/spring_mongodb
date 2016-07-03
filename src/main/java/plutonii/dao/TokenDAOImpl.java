package plutonii.dao;

import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plutonii.model.UserToken;

@Repository
public  class TokenDAOImpl implements TokenDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public void addToken(UserToken token) throws SQLException {
		getCurrentSession().save(token);
	}


	public void deleteToken(String UserID) throws SQLException{
		UserToken token = (UserToken) getCurrentSession().createQuery("from UserToken token where token.id = :id1")
				.setParameter("id1", UserID).list().get(0);
		getCurrentSession().delete(token);
	}


	public void refreshToken(String UserID) throws SQLException{
		UserToken token = (UserToken) getCurrentSession().createQuery("from UserToken token where token.id = :id1")
				.setParameter("id1", UserID).list().get(0);
		getCurrentSession().update(token);
	}
    
	

}
