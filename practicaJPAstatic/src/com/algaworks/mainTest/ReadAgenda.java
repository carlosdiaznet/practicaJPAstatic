package com.algaworks.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Agenda;

public class ReadAgenda {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Agenda agenda = em.find(Agenda.class, 2);
		em.getTransaction().commit();
		
		System.out.println("Los datos son:");
		System.out.println("Nombre: " + agenda.getNombre());
		System.out.println("Telefono: " + agenda.getTelefono());
		System.out.println("Fecha de registro: " + agenda.getFechaRegistro());
	}
}
