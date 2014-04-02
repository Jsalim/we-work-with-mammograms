package models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;

import play.db.ebean.Model;

@Entity
public class Staff extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	Long id;
	
	@Required
	String email;
	
	@Required
	String password;
	
	@Required
	String role;
	
	@Required
	String name;

	@Required
	String firstLastName;
	
	@Required
	String secondLastName;
	
	@Required
	Date birthdate;
	
	@Required
	String cedula;
	
	@Required
	String RFC;
	
	@OneToMany(mappedBy="owner")
	Set<Patient> ownPatients;
	
	@OneToMany(mappedBy="commenter")
	Set<Comment> comments;
	
	@OneToMany(mappedBy="ownsPermission")
	Set<Permission> permissions;
	
	@OneToMany(mappedBy="annotator")
	Set<Annotation> annotations;
	
	@OneToMany(mappedBy="sharer")
	Set<SharedPatient> sharedPatients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public Set<Patient> getOwnPatients() {
		return ownPatients;
	}

	public void setOwnPatients(Set<Patient> ownPatients) {
		this.ownPatients = ownPatients;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}

	public Set<SharedPatient> getSharedPatients() {
		return sharedPatients;
	}

	public void setSharedPatients(Set<SharedPatient> sharedPatients) {
		this.sharedPatients = sharedPatients;
	}

}
