package com.pluralsight.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pluralsight.entities.Book;

public class Main {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
	private static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		persistBook(new Book(3279L, "JSF Full", "Building web aplication", 12.7f, "4521-1258-0", 246));
		Book book = findBook(3279L);
		System.out.println("# " + book);
	}
	
	private static void persistBook(Book book){
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
	}
	
	private static Book findBook(Long id){
		return em.find(Book.class, id);
	}
}
