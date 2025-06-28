package com.nammanoolagam.feature.libraryset;

import java.util.Scanner;

import com.nammanoolagam.feature.base.BaseView;
import com.nammanoolagam.feature.libraryset.details.LibraryDetailsView;
import com.nammanoolagam.repository.dto.Library;

public class LibrarySetupView extends BaseView {

	LibrarySetupModel model;

	private Scanner scanner = new Scanner(System.in);

	public LibrarySetupView() {

		model = new LibrarySetupModel(this);
	}

	public void init() {

		model.init();

	}

	public void proceedToSetupLibrary() {

		System.out.println("\n=== Library Setup ===");
		Library library = new Library();

		library.setName(getLibraryName());
		library.setAddress(getAddress());
		library.setPhoneNo(getPhoneNumber());
		library.setEmailId(getEmail());
		library.setIncharge(getIncharge());
		library.setCapacity(getCapacity());
		library.setOpeningTime(getOpeningTime());
		library.setClosingTime(getClosingTime());
		library.setNoAvailableDays(getAvailableDays());
		
		model.setUpLibrary(library);

	}

	private String getLibraryName() {

		String name = "";
		System.out.println("Enter the Name");
		do {

			name = scanner.nextLine();
			if (name.length() < 3 || name.length() > 50) {

				System.out.println("Library name should be between 3 and 50 characters\\nEnter valid name");
			} else
				break;

		} while (true);

		return name;
	}

	private String getAddress() {
		String address = "";
		System.out.println("Enter Library Address:");
		do {
			address = scanner.nextLine();
			if (address.length() < 5 || address.length() > 100)
				System.out.println("Address should be between 5 and 100 characters\nEnter valid address:");
			else
				break;
		} while (true);
		return address;
	}

	private String getPhoneNumber() {
		String phone = "";
		System.out.println("Enter Phone Number:");
		do {
			phone = scanner.nextLine();
			if (!phone.matches("\\d{10}"))
				System.out.println("Phone number should be 10 digits\nEnter valid phone number:");
			else
				break;
		} while (true);
		return phone;
	}

	private String getEmail() {
		String email = "";
		System.out.println("Enter Email Address:");
		do {
			email = scanner.nextLine();
			if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
				System.out.println("Invalid email format\nEnter valid email:");
			else
				break;
		} while (true);
		return email;
	}

	private String getIncharge() {
		String incharge = "";
		System.out.println("Enter Library Incharge Name:");
		do {
			incharge = scanner.nextLine();
			if (incharge.length() < 3 || incharge.length() > 50)
				System.out.println("Name should be between 3 and 50 characters\nEnter valid name:");
			else
				break;
		} while (true);
		return incharge;
	}

	private Integer getCapacity() {
		Integer capacity = null;
		System.out.println("Enter Library Capacity:");
		do {
			try {
				capacity = Integer.parseInt(scanner.nextLine());
				if (capacity <= 0)
					System.out.println("Capacity should be greater than 0\nEnter valid capacity:");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number\nEnter valid capacity:");
			}
		} while (true);
		return capacity;
	}

	private Long getOpeningTime() {

		Long openingTime = null;
		System.out.println("Enter Opening Time (in 24-hour format, e.g., 900 for 9:00 AM");

		do {

			try {
				openingTime = Long.parseLong(scanner.nextLine());

				if (openingTime < 0 || openingTime > 2359)

					System.out.println("Time should be between 0000 and 2359\nEnter valid time:");

				else
					break;
			} catch (Exception e) {
				System.out.println("Enter the Valid Time");
			}

		} while (true);
		return openingTime;
	}

	private Long getClosingTime() {

		Long closingTime = null;

		System.out.println("Enter Closing Time (in 24-hour format, e.g., 1800 for 6:00 PM):");

		do {
			
           try {
			closingTime = Long.parseLong(scanner.nextLine());

			if (closingTime < 0 || closingTime > 2359) {

				System.out.println("Time should be between 0000 and 2359\\nEnter valid time:");
			} 
			else
				break;
           }
           
           catch(Exception e) {
        	   
        	   System.out.println("Please enter a valid time\\nEnter valid time:");
           }
           
		} while (true);

		return closingTime;
	}

	private Integer getAvailableDays() {

		Integer days = null;
		System.out.println("Enter Number of Available Days per Week (1-7):");

		do {

			try {
				days = Integer.parseInt(scanner.nextLine());

				if (days < 0 || days > 7) {

					System.out.println("Days should be between 1 and 7\\nEnter valid days:");
				} else
					break;

			} catch (Exception e) {

				System.out.println("Please enter a valid number\\nEnter valid days:");

			}

		} while (true);
		return days;
	}

	public void onLibrarySetupCompleted() {
		
		
		System.out.println("\nLibrary setup completed successfully!");
		
		showMainMenu();
		
	}
    
    
	public void showMainMenu() {
		while(true) {
			
		  System.out.println("\n=== Nammanoolagam Nammanoolagam Menu ===");
          System.out.println("1. Manage Books");
          System.out.println("2. View Books");
          System.out.println("3. Manage Users");
          System.out.println("4. View Users");
          System.out.println("5. View Library Details");
          System.out.println("6. Logout");
          System.out.println("7. Exit");
          System.out.print("Enter your choice: ");
          
          try {
        	  
        	  int choice =Integer.parseInt(scanner.nextLine());
        	  
        	  switch(choice) {
        	  
        	    case 1:
                    new com.nammanoolagam.feature.books.manage.BookManageView().init();
                    break;
                case 2:
                    new com.nammanoolagam.feature.books.BooksView().init();
                    break;
                case 3:
                    new com.nammanoolagam.feature.users.manage.UserManageView().init();
                    break;
                case 4:
                    new com.nammanoolagam.feature.users.UsersView().init();
                    break;
                case 5:
                    new LibraryDetailsView().init();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    new com.nammanoolagam.feature.registration.RegistrationView().init();
                    return;
                case 7:
                    exitApp();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        		  
        	  }
          
     catch(Exception e) {
        	  
        	  System.out.println("Enter the Valid Number");
          }
        	  
          }
          
          
		}
	
	
	
	
	
	
	
	
	}
    
    

