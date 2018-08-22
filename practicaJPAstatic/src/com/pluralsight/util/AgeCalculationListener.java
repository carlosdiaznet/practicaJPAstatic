package com.pluralsight.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.pluralsight.entities.Musician;

public class AgeCalculationListener {
	
	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge(Musician musician){
		System.out.println("DataValidationListener calculateAge()");
		if(musician.getDateOfBirth() == null){
			musician.setDateOfBirth(null);
			return;
		}
		Calendar birth = new GregorianCalendar();
		birth.setTime(musician.getDateOfBirth());
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;
		if(now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR)<0){
			adjust = -1;
		}
		//author.setAge(now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust);
		//musician.setDateOfBirth(now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust);
		
	}
}
