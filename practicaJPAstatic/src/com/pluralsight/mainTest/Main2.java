package com.pluralsight.mainTest;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pluralsight.entities.Book;
import com.pluralsight.services.BookService;

public class Main2 {
	public static void main(String[] args) throws  SQLException, ClassNotFoundException{
		System.out.println(">> Executing : " + Main2.class.toString() + " <<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		BookService service = new BookService(em);
		
		tx.begin();
			Book book = service.createBook(1507L, "Acuarela para todos", "Tecnicas modernas de acuarela", 21.35f, "5478-8523-45", 211);
		tx.commit();
		
		System.out.println("Book persisted: " + book);
		
		book = service.findBook(2407L);
		
		System.out.println("Book found: " + book);
		
		tx.begin();
			book = service.raiseUnitCost(2403L, 12.5f);
		tx.commit();
		
		System.out.println("Book update: " + book);
		
		//Aqui los metodos de eliminacion
		// Removes the book
	    tx.begin();
	    service.removeBook(2407L);
	    tx.commit();

	    System.out.println("Book Removed");

	    // Finds the book
	    book = service.findBook(2407L);

	    System.out.println("Book Not Found : " + book);
		
		em.close();
		emf.close();
	}
}
