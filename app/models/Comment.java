package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Comment extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	Long id;
	
	@MaxLength(value = 200)
	String content;
	
	@Required
	Date createdAt = new Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="staff_id", nullable=false)
	Staff commenter;
	
	@ManyToOne
	@JoinColumn(name="study_id", nullable=false)
	Study commented;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Staff getCommenter() {
		return commenter;
	}

	public void setCommenter(Staff commenter) {
		this.commenter = commenter;
	}

	public Study getCommented() {
		return commented;
	}

	public void setCommented(Study commented) {
		this.commented = commented;
	}
	
}
