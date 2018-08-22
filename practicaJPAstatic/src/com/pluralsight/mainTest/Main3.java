package com.pluralsight.mainTest;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pluralsight.entities.Author;
import com.pluralsight.services.AuthorService;

import static com.pluralsight.util.Language.ENGLISH;
import static com.pluralsight.util.Util.date;

public class Main3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("\n\n>>> Executing : " + Main3.class.toString() + " <<<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		AuthorService service = new AuthorService(em);
		//Author author = new Author("Douglas", "Adams", "Adams is best known as the author of H2G2", date("11/03/1952"), 49, ENGLISH);
		Author author = new Author("Douglas", "Adams", "Adams is best known as the author of H2G2", date("11/03/1952"), 49, ENGLISH);
		
		tx.begin();
		 author = service.createAuthor(author);
		tx.commit();
		int id = author.getId();
		
		System.out.println("Author persisted: " + author);
		
		author = service.findAuthor(id);
		
		System.out.println("Author found: " + author);
		
		em.close();
		emf.close();
	}
}
