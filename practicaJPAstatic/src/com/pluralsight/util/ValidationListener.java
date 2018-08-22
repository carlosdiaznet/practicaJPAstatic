package com.pluralsight.util;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.pluralsight.entities.Musician;

public class ValidationListener {
	// ======================================
	  // =          Lifecycle Methods         =
	  // ======================================
	
	@PrePersist
	@PreUpdate
	private void validate(Musician musician){
		System.out.println("DataValidationListener validate()");
		if(musician.getFirstName() == null || "".equals(musician.getFirstName()))
			throw new IllegalArgumentException("firstName es NULL");
		if(musician.getLastName() == null || "".equals(musician.getLastName()))
			throw new IllegalArgumentException("lastName es NULL");
	}
	
	
}
