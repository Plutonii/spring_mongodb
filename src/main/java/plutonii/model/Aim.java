package plutonii.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Aim {

	@Id
	private String id;		// unique identificator;
	
	private int number;		// number's aim;
	private String idHead;		// id the aim of the top-level;
	private String description;		// aim transcript;
	private String personalAim; 	// ????????;
	private String ratingMeasure;		// rating measure for performance evaluation;
	private int expectedValue;		// the expected value of performance aims;
	private Date realizDate;		// realization date;
	private int valueAim;		// aim weight;
	private String comment;		// comments for aims;
	private int expectedrating;		// expected rating;
	private String commentRating;		// comments for rating;
	private String idCreatorAim;		// id creator of aim;
	
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
	
	public int getExpectedrating() {
		return expectedrating;
	}
	
	public void setExpectedrating(int expectedrating) {
		this.expectedrating = expectedrating;
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
	
}