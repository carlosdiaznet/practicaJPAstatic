package com.pluralsight.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.pluralsight.entities.Book;
import com.pluralsight.entities.Musician;


public class QueryService {
	private EntityManager em;

	public QueryService(EntityManager em) {
		this.em = em;
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
	
	/*SE EJECUTAN EN MAIN6*/
	public void QueryBooks(){
		Query query = em.createQuery("SELECT b FROM Book b WHERE b.unitCost > 25 AND b.nbOfPage < 300");
		List books = query.getResultList(); //Devuelve una lista de objetos
		
		for(int i=0; i< books.size(); i++){
			Book book = (Book) books.get(i); //se obtiene el objeto segun el indice
		
			System.out.println(book);
		}
	}
	
	public void QueryBooksTyped(){
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.unitCost > 25 AND b.nbOfPage < 300", Book.class);
		List<Book> books = query.getResultList();
		
		for(Book book: books){
			System.out.println(books);
		}
	}
	
	public void queryBooksPosition(Float unitCost, Integer nbOfPage){
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.unitCost > ?1 AND b.nbOfPage < ?2", Book.class);
		query.setParameter(1, unitCost);
		query.setParameter(2, nbOfPage);
		List<Book> books = query.getResultList();
		
		for(int i=0; i< books.size(); i++){
			Book book = (Book) books.get(i);
			System.out.println(book);
		}
		
	}
	
	public void queryBookName(Float unitCost, Integer nbOfPage){
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.unitCost > :cost AND b.nbOfPage < :pages", Book.class);
		query.setParameter("cost", unitCost);
		query.setParameter("pages", nbOfPage);
		query.setMaxResults(2);
		List<Book> books = query.getResultList();
		
		for(int i=0; i<books.size();i++){
			Book book = books.get(i);
			System.out.println(book);
		}
	}
	
	public void dateQuery(String dateOfBirth){
		Date date = StringToDate(dateOfBirth);
		TypedQuery<Musician> query = em.createQuery("SELECT m FROM Musician m WHERE m.dateOfBirth = :dateBirth", Musician.class);
		query.setParameter("dateBirth", date);
		List<Musician> musicians = query.getResultList();
		
		for(Musician musician: musicians){
			System.out.println(musician);
		}
	}
	
	
}
