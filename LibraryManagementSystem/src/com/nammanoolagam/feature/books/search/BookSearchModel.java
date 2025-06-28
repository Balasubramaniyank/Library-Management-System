package com.nammanoolagam.feature.books.search;

import java.util.List;
import java.util.stream.Collectors;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.Book;
import java.util.stream.Collectors;

public class BookSearchModel {

	
	BookSearchView  view ;
	
	
	public BookSearchModel(BookSearchView view) {
		this.view= view;
	}


	public void searchByName(String name) {
		
		   if (name == null || name.trim().isEmpty()) {
	            view.showMessage("Please enter a valid name.");
	            return;
	        }

		
		List<Book> books = nammanoolagamDb.getInstance().getBooks().stream()
				           .filter(book->book.getName().toLowerCase().contains(name.toLowerCase()))
				        	.collect(Collectors.toList());
				           
				   view.displayBooks(books);        
		
		
	}


	public void searchByAuthor(String author) {
		
	  if(author == null || author.trim().isEmpty()) {
		  view.showMessage("Please enter a valid Author");
          return;
		  
	  }
	  
	  List<Book> books=nammanoolagamDb.getInstance().getBooks().stream()
			           .filter(book->book.getAuthor().contains(author))
			           .collect(Collectors.toList());
	  
	         view.displayBooks(books);
	
		
	}


	public void searchByGenre(String genre) {
		
		
		if(genre == null && genre.trim().isEmpty()) {
			
			view.showMessage("Please Enter a Valid Genre");
			return;
		}
		
		List<Book> books=nammanoolagamDb.getInstance().getBooks().stream()
				         .filter(book->book.getGenre().contains(genre))
				         .collect(Collectors.toList());
				
		
	}
	
	
	
}
