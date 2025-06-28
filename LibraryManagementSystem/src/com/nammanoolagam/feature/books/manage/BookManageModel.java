package com.nammanoolagam.feature.books.manage;

import java.util.List;
import java.util.UUID;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.Book;

public class BookManageModel {
	
	
	BookManageView view ;
	
	public BookManageModel(BookManageView Bookmanageview) {
		
		view=Bookmanageview;
		
	}

	public void addBook(Book book) {
		
		if(validateBook(book)) {
			
			book.setId(generateId());

			nammanoolagamDb.getInstance().addBook(book);
			view.showSuccessMessage("Book added successfully!");
			
		}
		
		
		
	}

	

	private boolean validateBook(Book book) {
		
		
		
		return    book.getAuthor()!=null && 
				  book.getName()!=null && 
				  book.getVolume()>0  &&
				  book.getAvailableCount()>0 &&
				  book.getNoOfCopy()>0 &&
				  book.getGenre()!=null&&
				  book.getPublishedYear()>0&&
				  book !=null;
				    
				  
				   
	}
	
	
	private String generateId() {
		
		return "BJ" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	public void viewAllBooks() {
		
		List<Book> books=nammanoolagamDb.getInstance().getBooks();
		view.displayBooks(books);
		
	}
	
	
	
}
