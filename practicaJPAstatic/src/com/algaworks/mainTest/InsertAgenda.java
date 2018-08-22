package com.algaworks.mainTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.entities.Agenda;

public class InsertAgenda {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStatic");
		EntityManager em = emf.createEntityManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Agenda agenda = new Agenda();
		agenda.setNombre("DINA ESTHER CORDOVA DE DIAZ");
		agenda.setTelefono("77659678");
		String fecha = "2018-04-11";
		
		Date miFecha;
		try {
			miFecha = sdf.parse(fecha);
			agenda.setFechaRegistro(miFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Registro almacenado");
	}

}
