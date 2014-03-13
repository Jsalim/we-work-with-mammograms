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
public class Annotation extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id
	Long id;
	
	@MaxLength(value = 200)
	String content;
	
	@Required
	Date createdAt = new Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="mammogram_id", nullable=false)
	Mammogram annotated;
	
	@ManyToOne
	@JoinColumn(name="staff_id", nullable=false)
	Staff annotator;
	
}
