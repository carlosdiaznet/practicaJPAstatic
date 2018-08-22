package com.algaworks.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Agenda;

public class UpdateAgenda {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class, 2);
		
		em.getTransaction().begin();
		agenda.setNombre("ANDREA FERNANDA DIAZ CORDOVA");
		em.merge(agenda);
		em.getTransaction().commit();
		System.out.println("Actualizacion finalizada");
	}
}
