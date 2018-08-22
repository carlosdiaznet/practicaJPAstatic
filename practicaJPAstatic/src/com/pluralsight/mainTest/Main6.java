package com.pluralsight.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pluralsight.services.QueryService;

public class Main6 {
	public static void main(String[] args) {
		System.out.println("\n\n>>> Executing : " + Main6.class.toString() + " <<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		QueryService service = new QueryService(em);
		
	
		
		
		System.out.println("___________Result");
	//	service.QueryBooks(); 
	//	service.QueryBooksTyped();
	//	service.queryBooksPosition(25f, 300);
		service.queryBookName(5f, 300);
	//	service.dateQuery("1991/07/24");
	}
}
