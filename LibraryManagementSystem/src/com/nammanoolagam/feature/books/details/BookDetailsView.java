package com.nammanoolagam.feature.books.details;

import java.util.List;
import java.util.Scanner;

import com.nammanoolagam.repository.dto.Book;

public class BookDetailsView {
    
	
	private final Scanner scanner =new Scanner (System.in);
	BookDetailsModel model;
	
	
	public BookDetailsView() {
		
		model = new BookDetailsModel(this);
		
	}


	public void init() {
		
		showMenu();
		
	}


	private void showMenu() {
		
		while(true) {
			
			    System.out.println("\n=== Book Details ===");
	            System.out.println("1. View Book Details");
	            System.out.println("2. Back to Nammanoolagam Menu");
	            System.out.println("3. Logout");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	           
	            try {
	       int choice =Integer.parseInt(scanner.nextLine()); 
	       
	        switch(choice) {
	        
	        case 1:
	        	ViewBookDetails();
	        	break;
	        
	        
	        }
	        
	        
	       
	            }
	            catch(Exception e) {
	            	
	            	
	            	System.out.println("Enter the Valid Number");
	            }
	            
	            
	            
	            
	            
	            
	            
		}
		
	}


	private void ViewBookDetails() {
	
			System.out.println("Enter the Book Name");
			
			String name = scanner.nextLine();
			
			model.getDisplayBooks(name);
		
	}


	 void showMessage(String message) {
		
		 System.out.println(message);
		
	}


	public void displayBooks(List<Book> books){
		
		if (books.isEmpty()) {
	        System.out.println("\nNo books found.");
	        return;
	    }

	    System.out.println("\n=== Search Results ===");
	    System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
	            "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
	    System.out.println("--------------------------------------------------------------------------------");
	    
	    for (Book book : books) {
	    	
	        System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",
	                book.getId(),
	                book.getName(),
	                book.getAuthor(),
	                book.getGenre(),
	                book.getVolume(),
	                book.getPublishedYear(),
	                book.getAvailableCount());
	    }
		
		
	}
	
	
}
