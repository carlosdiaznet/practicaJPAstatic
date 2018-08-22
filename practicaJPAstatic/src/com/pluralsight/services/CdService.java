package com.pluralsight.services;

import javax.persistence.EntityManager;

import com.pluralsight.entities.Cd;

public class CdService {
	
	private EntityManager em;

	public CdService(EntityManager em) {
		this.em = em;
	}
	
	/** Metodos publicos **/
	
	public Cd createCD(Cd cd){
		em.persist(cd);
		return cd;
	}
	
	public Cd findCd(int id){
		return em.find(Cd.class, id);
	}
}
