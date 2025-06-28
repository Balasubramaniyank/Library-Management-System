package com.nammanoolagam.feature.books.details;

import java.util.List;
import java.util.stream.Collectors;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.Book;

public class BookDetailsModel {

	BookDetailsView view ;
	
	public BookDetailsModel(BookDetailsView view) {
		
		this.view=view;
	}

	public void getDisplayBooks(String name) {
		
		
		if(name == null || name.trim().isEmpty()) {
			
			view.showMessage("Please enter a valid Book ID.");
			return;
			
		}
		
		List<Book> books=nammanoolagamDb.getInstance().getBooks().stream()
				   .filter(book->book.getName().contains(name))
				   .collect(Collectors.toList());
		
		view.displayBooks(books);
		
	}
	
	
}
