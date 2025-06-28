package com.nammanoolagam.repository.db;

import java.util.ArrayList;

import java.util.List;

import com.nammanoolagam.repository.dto.Library;
import com.nammanoolagam.repository.dto.RegistrationInfo;
import com.nammanoolagam.repository.dto.User;
import com.nammanoolagam.repository.dto.Book;

public class nammanoolagamDb {
	
	private static nammanoolagamDb  snammanoolagamDb ;
	
	
	 private   RegistrationInfo registrationInfo;
	 
	
	 private Library library;
	 private List<Book> books = new ArrayList<>();

     private List<User> users = new ArrayList<>();




	public static nammanoolagamDb getInstance() {
    	  
    	  
    	  if(snammanoolagamDb==null) {
    		  
    		  snammanoolagamDb = new nammanoolagamDb();
    	  }

    		  return snammanoolagamDb;
      }


	public RegistrationInfo getRegistrationInfo() {
		return registrationInfo;
	}
	
	

	public void setRegistrationInfo(RegistrationInfo registrationInfo) {
		this.registrationInfo = registrationInfo;
	}

	
	public Library getLibrary() {
		return library;
	}


	public void setLibrary(Library library) {
		
		this.library = library;
	}


	public boolean validateCredentials(String userName, String password) {
	
		 if(registrationInfo.getUserName().equals(userName)&&registrationInfo.getPassword().equals(password)) {
			 
			 return true;
		 }
		
		return false;
	}

	public void addBook(Book book) {
		
		books.add(book);
	}
	
	public void addUser(User user) {
		
		users.add(user);
	}
	
	 public List<Book> getBooks() {
			return books;
		}


		public void setBooks(List<Book> books) {
			this.books = books;
		}
	
		
		public List<User> getUsers(){
			
			
		return new ArrayList<>(users); 
		}
	
}
