package com.pluralsight.mainTest;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pluralsight.entities.Cd;
import com.pluralsight.services.CdService;

public class Main4 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("\n\n>>> Ejecutando : " +  Main4.class.toString() + " <<<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		CdService service = new CdService(em);
		Cd cd = new Cd("Hillsong Live", "Cd Music a wordl", "Christian Music", 47f, 23f);
		
		tx.begin();
			cd = service.createCD(cd);
		tx.commit();
		
		int id = cd.getId();
		
		System.out.println("Cd persisted: " + cd);
		
		cd = service.findCd(id);
		
		System.out.println("Cd found: " + cd);
		
		em.close();
		emf.close();
	}
}
