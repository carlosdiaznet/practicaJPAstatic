package com.pluralsight.mainTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pluralsight.entities.Musician;
import com.pluralsight.services.MusicianService;

public class Main9 {
	public static void main(String[] args) {
		System.out.println("\n\n>>> Executing : " + Main9.class.toString() + " <<<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/** Musician Service **/
		MusicianService service = new MusicianService(em);
		
		System.out.println("Crear y validar un Musician");
		tx.begin();
		int id = service.createMusician(new Musician("Andrea Fernanda", "Cordova Diaz", "Medico en EEUU", date("24/07/1993"), "Guitar"));
		tx.commit();
		em.clear();
		
		System.out.println("\n---- findMusician");
		System.out.println(service.findMusician(id));
		
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
