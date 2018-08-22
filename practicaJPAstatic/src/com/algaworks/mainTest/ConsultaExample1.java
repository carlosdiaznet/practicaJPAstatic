package com.algaworks.mainTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Cliente;

public class ConsultaExample1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		//String cliente2 =  (String) em.createNativeQuery("SELECT NOMBRE FROM CLIENTE WHERE CODIGO = 1;");
		if(cliente != null){
		System.out.println("Nombre: " + cliente.getNombre());
		System.out.println("Edad: " + cliente.getEdad());
		System.out.println("Sexo " + cliente.getSexo());
		System.out.println("Profesion: " + cliente.getProfesion());
		} else {
			System.out.println("Cliente no encontrado...");
		}
	}
}
