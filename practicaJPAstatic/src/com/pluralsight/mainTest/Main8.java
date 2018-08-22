package com.pluralsight.mainTest;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static com.pluralsight.util.Language.ENGLISH;
//import static com.pluralsight.util.Util.date;
import com.pluralsight.entities.Author;
import com.pluralsight.services.AuthorService;

public class Main8 {
	public static void main(String[] args) {
System.out.println("\n\n>>> Executing : " + Main8.class.toString() + " <<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		AuthorService service = new AuthorService(em);
		
		System.out.println("---- Crear invalid author-----");
		Author author = new Author("Fernanda Andrea", "Cordova", "Autora de muchos libros y escritos", date("24/07/1995"), 49, ENGLISH);
		tx.begin();
		//Integer id = service.createAuthor(null, null, null, "validacion null", date("01/01/1975"), ENGLISH);
		author = service.createAuthor(author);
		tx.commit();
		
		int id = author.getId();
		
		author = service.findAuthor(id);
		System.out.println("Author found: " + author);
		
		em.close();
		emf.close();
		
	}
	
	private static Date date(String s){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return dateFormat.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
