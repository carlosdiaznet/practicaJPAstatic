package com.pluralsight.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CD")
public class Cd {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CD_SEQ")
	@SequenceGenerator(name = "CD_SEQ", sequenceName = "CD_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="DESCRIPTION", length=255)
	private String description;
	
	@Column(name="GENRE", length=255)
	private String genre;
	
	@Column(name="TOTAL_DURATION")
	private float totalDuration;
	
	@Column(name="UNIT_COST")
	private float unitCost;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_CD")
	private Set<Musician> musicians = new HashSet<>();
	
	/* CONSTRUCTOR */
	
	public Cd() {
	}
	
	public Cd(String title){
		this.title = title;
	}

	public Cd(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}



	public Cd(String title, String description, String genre, float totalDuration, float unitCost) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.totalDuration = totalDuration;
		this.unitCost = unitCost;
	}
	
	/** Getter & Setter **/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	
	

	public Set<Musician> getMusicians() {
		return musicians;
	}



	public void setMusicians(Set<Musician> musicians) {
		this.musicians = musicians;
	}



	@Override
	public String toString() {
		return "Cd [id=" + id + ", title=" + title + ", description=" + description + ", genre=" + genre
				+ ", totalDuration=" + totalDuration + ", unitCost=" + unitCost + "]";
	}
	
	
}
