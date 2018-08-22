package com.pluralsight.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.pluralsight.util.AgeCalculationListener;
import com.pluralsight.util.ValidationListener;

@Entity

@EntityListeners({
	//AgeCalculationListener.class,
	ValidationListener.class
})

@Table(name="MUSICIAN")
@NamedQueries({
	@NamedQuery(name="BirthMusician", query="SELECT m FROM Musician m WHERE m.dateOfBirth BETWEEN :date1 AND :date2")
})
public class Musician {
	/* ATRIBUTOS */
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MUSICIAN_SEQ")
	@SequenceGenerator(name = "MUSICIAN_SEQ", sequenceName = "MUSICIAN_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="FIRST_NAME", length=55)
	protected String firstName;
	
	@Column(name="LAST_NAME", length=255)
	protected String lastName;
	
	@Column(name="BIO", length=255)
	protected String bio;
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	protected Date dateOfBirth;
	
	@Column(name="PREFERRED_INSTRUMENT", length=55)
	private String preferredInstrument;
	
	@Transient
	private Integer age;
	
	/*CONSTRUCTORES*/
	
	public Musician() {
	}

	public Musician(String firstName, String lastName, String bio, Date dateOfBirth, String preferredInstrument) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.dateOfBirth = dateOfBirth;
		this.preferredInstrument = preferredInstrument;
	}

	public Musician(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**GETTERS & SETTERS**/

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

	public String getPreferredInstrument() {
		return preferredInstrument;
	}

	public void setPreferredInstrument(String preferredInstrument) {
		this.preferredInstrument = preferredInstrument;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Musician [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", bio=");
		builder.append(bio);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", preferredInstrument=");
		builder.append(preferredInstrument);
		builder.append("]");
		return builder.toString();
	}
	
	
}
