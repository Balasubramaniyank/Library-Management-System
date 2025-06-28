package com.nammanoolagam.feature.books;

import java.util.List;
import java.util.Scanner;

import com.nammanoolagam.feature.base.BaseView;
import com.nammanoolagam.feature.books.details.BookDetailsView;
import com.nammanoolagam.feature.books.manage.BookManageView;
import com.nammanoolagam.feature.books.search.BookSearchView;
import com.nammanoolagam.feature.libraryset.LibrarySetupView;
import com.nammanoolagam.repository.dto.Book;

public class BooksView extends BaseView{

	
	private final BooksModel model;
	
	private final Scanner scanner = new Scanner(System.in);
	
	
	public BooksView() {
		
		model = new BooksModel(this);
		
	}
	
	


	public void init() {
		
		showView();
		
	}




	private void showView() {
	
		
		while(true) {
			
			    System.out.println("\n=== Books ===");
	            System.out.println("1. View All Books");
	            System.out.println("2. Search Books");
	            System.out.println("3. Manage Books");
	            System.out.println("4. View Book Details");
	            System.out.println("5. Back to Nammanoolagam Menu");
	            System.out.println("6. Logout");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            
			
			try {
				
				int choice = Integer.parseInt(scanner.nextLine());
				switch(choice) {
				
				case 1:
					model.viewAllBooks();
					
				case 2 :
					 
					new BookSearchView().init();
					break;
				case 3:
					new BookManageView().init();
					break;
				case 4:
					new BookDetailsView().init();
					 break;
				case 5:
				      new LibrarySetupView().showMainMenu();
				      break;
				case 6:
					 logoutApp();
					 break;
				case 7:
					 exitApp();
				 default:
					 System.out.println("Enter the Valid Choice");
					
				}
				
				
			}
			catch(Exception e) {
				
				System.out.println("Enter the Valid Number!");
				
				
				
			}
			
			
		}
		
	}




	public void displayBook(List<Book> books) {
		if (books.isEmpty()) {
            System.out.println("\nNo books found.");
            return;
        }

        System.out.println("\n=== Book List ===");
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
	
	
	
	

