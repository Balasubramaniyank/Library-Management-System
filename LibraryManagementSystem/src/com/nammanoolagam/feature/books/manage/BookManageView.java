package com.nammanoolagam.feature.books.manage;

import java.util.List;
import java.util.Scanner;

import com.nammanoolagam.repository.dto.Book;
import com.nammanoolagam.feature.base.BaseView;
import com.nammanoolagam.feature.books.BooksView;
import com.nammanoolagam.feature.libraryset.*;

public class BookManageView extends BaseView {

	BookManageModel model;

	private final Scanner scanner = new Scanner(System.in);

	public BookManageView() {

		model = new BookManageModel(this);

	}

	public void init() {

		showMenu();

	}

	private void showMenu() {

		while (true) {

			System.out.println("\n=== Book Management ===");
			System.out.println("1. Add New Book");
			System.out.println("2. View All Books");
			System.out.println("3. Back to Nammanoolagam Menu");
			System.out.println("4. Logout");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());
			
				switch (choice) {

				case 1:
					addNewBooks();
					break;
					
				case 2:
					model.viewAllBooks();
                    break;
				
				case 3:
					new LibrarySetupView().showMainMenu();
					break;
					
				case 4:
				   logoutApp();	
				break;
				case 5:
					exitApp();
					
				  default :
					  System.out.println("Invalid choice. Please try again.");
			
				}	
				
					

			} catch (Exception e) {
				
				
				System.out.println("Please enter a valid number.");
			}

		}

	}

	private void addNewBooks() {

		System.out.println("\n=== Add New Book ===");
		Book book = new Book();

		book.setName(getBookName());
		book.setAuthor(getAuthor());
		book.setGenre(getGenre());
		book.setVolume(getVolume());
		book.setPublishedYear(getPublishedYear());
		book.setNoOfCopy(getNoOfCopies());
		book.setAvailableCount(book.getNoOfCopy());
		
		 model.addBook(book);

	}

	private String getBookName() {

		String name = "";
		System.out.println("Enter Book Name:");
		do {
			name = scanner.nextLine();
			if (name.length() < 2 || name.length() > 100)
				System.out.println("Book name should be between 2 and 100 characters\nEnter valid name:");
			else
				break;
		} while (true);
		return name;

	}

	private String getAuthor() {

		String author = "";
		System.out.println("Enter Author Name:");
		do {
			author = scanner.nextLine();
			if (author.length() < 2 || author.length() > 50)
				System.out.println("Author name should be between 2 and 50 characters\nEnter valid name:");
			else
				break;
		} while (true);
		return author;

	}

	private String getGenre() {

		String genre = "";
		System.out.println("Enter Book Genre:");
		do {
			genre = scanner.nextLine();
			if (genre.length() < 2 || genre.length() > 30)
				System.out.println("Genre should be between 2 and 30 characters\nEnter valid genre:");
			else
				break;
		} while (true);
		return genre;

	}

	private byte getVolume() {
		byte volume = 0;
		System.out.println("Enter Volume Number:");
		do {
			try {
				volume = Byte.parseByte(scanner.nextLine());
				if (volume <= 0)
					System.out.println("Volume should be greater than 0\nEnter valid volume:");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number\nEnter valid volume:");
			}
		} while (true);
		return volume;
	}

	private Integer getPublishedYear() {
		Integer year = null;
		System.out.println("Enter Published Year:");
		do {
			try {
				year = Integer.parseInt(scanner.nextLine());
				if (year < 1800 || year > 2025)
					System.out.println("Year should be between 1800 and 2025\nEnter valid year:");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid year\nEnter valid year:");
			}
		} while (true);
		return year;
	}

	private byte getNoOfCopies() {
		byte copies = 0;
		System.out.println("Enter Number of Copies:");
		do {
			try {
				copies = Byte.parseByte(scanner.nextLine());
				if (copies <= 0)
					System.out.println("Number of copies should be greater than 0\nEnter valid number:");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number\nEnter valid number:");
			}
		} while (true);
		return copies;
	}

	public void showSuccessMessage(String message) {
		
		System.out.println(message);
		
	}

	public void displayBooks(List<Book> books) {
		
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
    
	
    
    
    
	

