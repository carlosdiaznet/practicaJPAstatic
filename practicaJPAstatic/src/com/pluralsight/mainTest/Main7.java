package com.pluralsight.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pluralsight.services.QueryServiceNamed;

public class Main7 {
	public static void main(String[] args) {
		System.out.println("\n\n>>> Executing : " + Main7.class.toString() + " <<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		QueryServiceNamed service = new QueryServiceNamed(em);
		
		System.out.println("___________Result");
		
	//	service.queryBooks();
	//	service.queryBooksTyped();
	//	service.queryBooksPosition(21f, 300);
	//	service.queryBooksBetween(15f, 50f);
		service.queryMusicianDate("1980/01/01", "1985/12/31");
	}
}
