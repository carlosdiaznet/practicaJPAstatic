package com.algaworks.mainTest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Cliente;

public class ConsultaJPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("FROM Cliente WHERE sexo = 'F'", Cliente.class)
				.getResultList();
			for(Cliente cliente: clientes){
				System.out.println("Codigo: " + cliente.getCodigo());
				System.out.println("Nombre: " + cliente.getNombre());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Profesion: " + cliente.getProfesion());
				System.out.println("________________________________________");
			}
	}
}
