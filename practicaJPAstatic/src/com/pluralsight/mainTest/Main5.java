package com.pluralsight.mainTest;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pluralsight.entities.Cd;
import com.pluralsight.entities.Musician;
import com.pluralsight.services.CdService;

import static com.pluralsight.util.Util.date;

public class Main5 {
	public static void main(String[] args) {
		System.out.println("\n\n>>> Ejecutando : " +  Main5.class.toString() + " <<<\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		CdService service = new CdService(em);
		
		//Creando y persistiendo un CD
		
		tx.begin();
		Set<Musician> hillsong = new HashSet<>();
		hillsong.add(new Musician("Taya", "Smith", "Taya is best known as the author of Hillsong", date("11/03/1952"), "Guitar"));
		hillsong.add(new Musician("Matt", "Crocker", "Matt is best musician as the author of Hillsong", date("11/09/1980"), "Guitar"));
		hillsong.add(new Musician("Hayley", "Law", "Haley is must as the author of Hillsong", date("15/03/1983"), "Bow"));
		hillsong.add(new Musician("Jihea", "Oh", "Jihea is best known as the author of Hillsong", date("24/07/1991"), "Guitar Acustic"));
		
		//Creamos el CD con un titulo
		Cd HillsongUnited = new Cd("Hillsong United 2", "Primer album de hillsong en australia", "Cristiana", 62.5f, 25f);
		
		//Enviamos a CD el parametro de tipo Musician (hillsong)
		HillsongUnited.setMusicians(hillsong);
		
		//se crea el cd con los musicos
		HillsongUnited = service.createCD(HillsongUnited);
		tx.commit();
		
		System.out.println("CD Persistido: " + HillsongUnited);
		
		//Busqueda del CD
		HillsongUnited = service.findCd(HillsongUnited.getId());
		
		System.out.println("CD encontrado: " + HillsongUnited);
		System.out.println(" Musicos: " + HillsongUnited.getMusicians());
		
		em.close();
		emf.close();
	}
}
