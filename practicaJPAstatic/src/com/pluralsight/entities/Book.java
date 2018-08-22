package com.pluralsight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Book.FIND_ALL, query="SELECT b FROM Book b"),
	@NamedQuery(name="ExpesiveBooks", query ="SELECT b FROM Book b WHERE b.unitCost < 26"),
	@NamedQuery(name="ParamPosBooks", query="SELECT b FROM Book b WHERE b.unitCost > ?1 AND b.nbOfPage < ?2"),
	@NamedQuery(name="ParamNameBooks", query="SELECT b FROM Book b WHERE b.unitCost BETWEEN :cost1 AND :cost2")
})
public class Book {
	/*Declaracion de atributos*/
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="UNIT_COST")
	private Float unitCost;
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="NBOFPAGE")
	private int nbOfPage;
	
	/* CONSTANTE */
	public static final String FIND_ALL = "Book.findAll";
	
	/*Constructores*/
	public Book(){
	}
	
	public Book(Long id){
		this.id = id;
	}

	public Book(Long id, String title, String description, Float unitCost, String isbn, int nbOfPage) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
	}
	
	/*Getter & Setters*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(int nbOfPage) {
		this.nbOfPage = nbOfPage;
	}
	
	/* hashcode, equals & toString*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost
				+ ", isbn=" + isbn + ", nbOfPage=" + nbOfPage + "]";
	}
}
