package plutonii.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document
public class Map {

	@Id
	private String id;		// unique identificator;
	
	private int year;		// year;
	private String status;		// status map's;
	private String lastChange;		// lastChangeMap;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastChange() {
		//Timestamp expTime = new Timestamp(lastChange);
		System.out.println(lastChange);
		return lastChange;
	}
	public void setLastChange(String lastChange) {
		System.out.println(lastChange);
		java.util.Date date= new java.util.Date();
		Timestamp expTime = new Timestamp(date.getTime());
		System.out.println(expTime);
		this.lastChange = expTime.toLocaleString();
		//this.lastChange = lastChange;
	}
	
}