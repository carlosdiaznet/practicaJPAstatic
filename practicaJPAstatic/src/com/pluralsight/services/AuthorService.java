package com.pluralsight.services;

import java.util.Date;

import javax.persistence.EntityManager;

import com.pluralsight.entities.Author;
import com.pluralsight.util.Language;

public class AuthorService {
	
	private EntityManager em;

	public AuthorService(EntityManager em) {
		this.em = em;
	}
	
	public Author createAuthor(Author author){
		em.persist(author);
		return author;
	}
	
	public Author createAuthor(int id, String firstName, String lastName, String bio, Date dateOfBirth, Language language){
		Author author = new Author();
		author.setId(id);
		author.setFirstName(firstName);
		author.setLanguage(language);
		author.setLastName(lastName);
		author.setBio(bio);
		author.setDateOfBirth(dateOfBirth);
		
		em.persist(author);
		return author;
	}
	
	public Author findAuthor(int id){
		return em.find(Author.class, id);
	}
	
	public void removeAuthor(Author author){
		em.remove(em.merge(author));
	}
}
