package plutonii.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.BasicDBObject;

import java.util.Calendar;
import java.util.Date;

@Document
public class Aim {

	@Id
	private String id;		// unique identificator;ид
	
	private int number;		// number's aim;номер
	private String idHead;		// id the aim of the top-level;ид цели верхнего уровня
	private String description;		// aim transcript;описание цели
	private String personalAim; 	// ????????;сама цель
	private String ratingMeasure;		// rating measure for performance evaluation;Мера рейтинга
	private int expectedValue;		// the expected value of performance aims;Ожидаемое значение
	private Date realizDate;		// realization date;Дата реализации
	private int valueAim;		// aim weight;Вес цели
	private String comment;		// comments for aims;Комментарий
	private int expectedRating;		// expected rating;Ожидаемый рейтинг
	private String commentRating;		// comments for rating;Комментарий к рейтингу
	private String idCreatorAim;		// id creator of aim;ид создателя цели (пользователя)
	private String idMap;
	


	public Aim (int number, String idHead, String description, String personalAim, String ratingMeasure,
			   int expectedValue, Date realizDate, int valueAim, String comment, int expectedRating,
			   String commentRating, String idCreatorAim, String idMap) {
		this.number = number;
		this.idHead = idHead;
		this.description = description;
		this.personalAim = personalAim;
		this.ratingMeasure = ratingMeasure;
		this.expectedValue = expectedValue;
		this.realizDate = realizDate;
		this.valueAim = valueAim;
		this.comment = comment;
		this.expectedRating = expectedRating;
		this.commentRating = commentRating;
		this.idCreatorAim = idCreatorAim;
		this.idMap = idMap;
	}
	
	public Aim() {
		
	}
	
	public String getIdMap() {
		return idMap;
	}

	public void setIdMap(String idMap) {
		this.idMap = idMap;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public String getIdHead() {
		return idHead;
	}
	
	public void setIdHead(String idHead) {
		this.idHead = idHead;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPersonalAim() {
		return personalAim;
	}
	
	public void setPersonalAim(String personalAim) {
		this.personalAim = personalAim;
	}
	
	public String getRatingMeasure() {
		return ratingMeasure;
	}
	
	public void setRatingMeasure(String ratingMeasure) {
		this.ratingMeasure = ratingMeasure;
	}
	
	public int getExpectedValue() {
		return expectedValue;
	}
	
	public void setExpectedValue(int expectedValue) {
		this.expectedValue = expectedValue;
	}
	
	public Date getRealizDate() {
		return realizDate;
	}
	
	public void setRealizDate(Date realizDate) {
		this.realizDate = realizDate;
	}
	
	public int getValueAim() {
		return valueAim;
	}
	
	public void setValueAim(int valueAim) {
		this.valueAim = valueAim;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getExpectedRating() {
		return expectedRating;
	}
	
	public void setExpectedrating(int expectedRating) {
		this.expectedRating = expectedRating;
	}
	
	public String getCommentRating() {
		return commentRating;
	}
	
	public void setCommentRating(String commentRating) {
		this.commentRating = commentRating;
	}

	public String getIdCreatorAim() {
		return idCreatorAim;
	}

	public void setIdCreatorAim(String idCreatorAim) {
		this.idCreatorAim = idCreatorAim;
	}
	
    public String toString() {
        return "AIM:\n" + this.id + "\nidCreated: " + this.idCreatorAim + "\nPersonal aim: " + this.personalAim;
    }
	
}