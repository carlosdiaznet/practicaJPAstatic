package com.pluralsight.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.pluralsight.entities.Book;
import com.pluralsight.entities.Musician;

public class QueryServiceNamed {
	private EntityManager em;

	public QueryServiceNamed(EntityManager em) {
		this.em = em;
	}
	/* se ejecuta en Main7 */
	public void queryBooks(){
		Query query = em.createNamedQuery("ExpesiveBooks");
		List books = query.getResultList();
		
		for(int i=0; i<books.size(); i++){
			Book book = (Book)books.get(i);
			System.out.println(book);
		}
	}
	
	public void queryBooksTyped(){
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		List<Book> books = query.getResultList();
		
		for(int i=0; i<books.size();i++){
			Book book = books.get(i);
			System.out.println(book);
		}
	}
	
	public void queryBooksPosition(Float unitCost, Integer nbOfPage){
		TypedQuery<Book> query = em.createNamedQuery("ParamPosBooks", Book.class);
		query.setParameter(1, unitCost);
		query.setParameter(2, nbOfPage);
		List<Book> books = query.getResultList();
		
		for(int i=0; i < books.size(); i++){
			Book book = books.get(i);
			System.out.println(book);
		}
	}
	
	public void queryBooksBetween(float cost1, float cost2){
		TypedQuery<Book> query = em.createNamedQuery("ParamNameBooks", Book.class);
		query.setParameter("cost1", cost1);
		query.setParameter("cost2", cost2);
		List<Book> books = query.getResultList();
		
		for(Book book: books){
			System.out.println(book);
		}
	}
	
	public void queryMusicianDate(String fecha1, String fecha2){
		Date date1 = StringToDate(fecha1);
		Date date2 = StringToDate(fecha2);
		TypedQuery<Musician> query = em.createNamedQuery("BirthMusician", Musician.class);
		
		query.setParameter("date1", date1, TemporalType.TIMESTAMP);
		query.setParameter("date2", date2, TemporalType.TIMESTAMP);
		List<Musician> musicians = query.getResultList();
		
		for(Musician musician: musicians){
			System.out.println(musician);
		}
	}
	
	
	/*FORMATO DE FECHAS*/
	public Date StringToDate(String s){

	    Date result = null;
	    try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	        result  = dateFormat.parse(s);
	    }

	    catch(ParseException e){
	        e.printStackTrace();

	    }
	    return result ;
	}
}
