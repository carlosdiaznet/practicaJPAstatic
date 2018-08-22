package com.algaworks.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Cliente;

public class ActualizandoExample1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		em.getTransaction().begin();
		cliente.setNombre("ANDREA FERNANDA DIAZ CORDOVA");
		em.getTransaction().commit();
		System.out.println("Cliente modificado...");
	}
}
