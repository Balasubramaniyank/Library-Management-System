package com.nammanoolagam.feature.books.search;

import java.util.List;
import java.util.Scanner;

import com.nammanoolagam.feature.base.BaseView;
import com.nammanoolagam.feature.books.BooksView;
import com.nammanoolagam.repository.dto.Book;

public class BookSearchView extends BaseView{
	
	private final Scanner scanner = new Scanner(System.in);
	
	
	
	BookSearchModel model;
	
	
  public BookSearchView () {
	  
	  model= new BookSearchModel(this);
	  
	  
  }


public void init() {
	
	showMenu();
	
}


private void showMenu() {
	
	
	while(true) {
		
		 System.out.println("\n=== Search Books ===");
         System.out.println("1. Search by Name");
         System.out.println("2. Search by Author");
         System.out.println("3. Search by Genre");
         System.out.println("4. Back to Nammanoolagam Menu");
         System.out.println("5. Logout");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");
		
			
		
		try {
			
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			
			case 1: 
			      System.out.println("Enter the Book Name");	
				model.searchByName(scanner.nextLine());
				break;
				
			case 2:
				System.out.println("Enter the Author");
				model.searchByAuthor(scanner.nextLine());
				break;
				
			case 3:
				System.out.println("Enter the Genre");
				model.searchByGenre(scanner.nextLine());
			     break;
			case 4:
				
				  new BooksView().init();
				  break;
			case 5:
				 logoutApp();
				 break;
				 
			case 6:
				 exitApp();
				
			
			  default:
			     System.out.println();
			}
			
			
		}
		catch(Exception e) {
			
			
			
		}
		
		
	}
	

	
}


public void displayBooks(List<Book> books) {
	
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


public void showMessage(String message) {
	
	System.out.println(message);
	
}
  

}
