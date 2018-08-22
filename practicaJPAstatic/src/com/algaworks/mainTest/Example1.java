package com.algaworks.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Cliente;



public class Example1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNombre("JUAN CARLOS DIAZ");
		cliente.setEdad(38);
		cliente.setSexo("M");
		cliente.setProfesion("INGENIERIA");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Almacenado correctamente...");
		
		
	
		em.close();
	}
}
