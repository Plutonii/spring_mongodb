package plutonii.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "TOKEN")

public class UserToken implements Serializable{
	
	
	private static final long serialVersionUID = -5527566248002196042L;
	
	@Id 
	@GeneratedValue
	@Column(name = "ID")
	private String ID;
	
	@Column (name = "userID")
	private String UserID;
	
	@Column (name = "token")
	private String token;
	
	@Column (name = "expTime")
	private Timestamp expTime;
	
	public String getUserID() {
		return UserID;
	}
	
	public void setUserID(String userID) {
		UserID = userID;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Timestamp getExpTime() {
		return expTime;
	}
	
	public void setExpTime(Timestamp expTime) {
		this.expTime = expTime;
	}

}
