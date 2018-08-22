package com.pluralsight.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.pluralsight.util.Language;

@Entity
@Table(name = "AUTHOR")
public class Author {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AUTHOR_SEQ")
	@SequenceGenerator(name = "AUTHOR_SEQ", sequenceName = "AUTHOR_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="FIRST_NAME", length=50)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="BIO", length=255)
	private String bio;
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Transient
	private Integer age;
	
	@Column(name="LANGUAGE")
	private Language language;
	
	  // ======================================
	  // =     Lifecycle Callback Methods Se ejecutan en main8   =
	  // ======================================
	/****
	@PrePersist
	@PreUpdate
	private void validate(){
		System.out.println("DataValidationListener validate()");
		if(firstName == null || "".equals(firstName))
			throw new IllegalArgumentException("firstName es NULL");
		if(lastName == null || "".equals(lastName))
			throw new IllegalArgumentException("lastName es NULL");
	}
	
	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge(){
		System.out.println("DataValidationListener calculateAge()");
		if(dateOfBirth == null){
			age = null;
			return;
		}
		Calendar birth = new GregorianCalendar();
		birth.setTime(dateOfBirth);
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;
		if(now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR)<0){
			adjust = -1;
		}
		age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
		
	}
	****/
	
	  // ======================================
	  // =            Constructors            =
	  // ======================================
	
	public Author() {
	}

	public Author(String firstName, String lastName, String bio, Date dateOfBirth, Integer age, Language language) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.language = language;
	}
	

	  // ======================================
	  // =          Getters & Setters         =
	  // ======================================

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", bio=");
		builder.append(bio);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", age=");
		builder.append(age);
		builder.append(", language=");
		builder.append(language);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
}
