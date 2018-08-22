package com.pluralsight.services;

import javax.persistence.EntityManager;

import com.pluralsight.entities.Book;

public class BookService {
	private EntityManager em;

	public BookService(EntityManager em) {
		this.em = em;
	}
	
	public Book createBook(Book book){
		em.persist(book);
		return book;
	}
	
	public Book createBook(Long id, String title, String description, float unitCost, String isbn, Integer nbOfPage){
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setUnitCost(unitCost);
		book.setIsbn(isbn);
		book.setNbOfPage(nbOfPage);
		
		em.persist(book);
		return book;
	}
	
	public Book findBook(Long id){
		return em.find(Book.class, id);
		//return book
	}
	
	public Book raiseUnitCost(Long id, float raise){
		Book book = em.find(Book.class, id);
		if(book != null){
			book.setUnitCost(book.getUnitCost() + raise);
		}
		return book;
	}
	
	public void removeBook(Long id){
		Book book = em.find(Book.class, id);
		if(book != null){
			em.remove(book);
		}
	}
	
	public void removeBook(Book book){
		em.remove(em.merge(book));
	}
}
