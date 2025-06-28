package com.nammanoolagam.feature.books;

import java.util.List;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.Book;

public class BooksModel {
	
	private final BooksView view;
	
	
	public BooksModel(BooksView view) {
		
		this.view= view;
		
	}


	public void viewAllBooks() {
		
		List<Book> books=nammanoolagamDb.getInstance().getBooks();
		
		view.displayBook(books);
		
		
		
	}

}
