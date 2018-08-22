package com.pluralsight.services;

import javax.persistence.EntityManager;

import com.pluralsight.entities.Musician;

public class MusicianService {
	private EntityManager em;

	public MusicianService(EntityManager em) {
		this.em = em;
	}
	
	/* Metodo para crear musicos */
	public int createMusician(Musician musician){
		em.persist(musician);
		return musician.getId();
	}
	
	/* Metodo para borrar musicos */
	public void removeMusician(Musician musician) {
		em.remove(em.merge(musician));
	}
	
	public Musician findMusician(int id){
		return em.find(Musician.class, id);
	}
	
	
	
}
