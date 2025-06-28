package com.nammanoolagam.feature.users.details;

import java.util.Scanner;

import com.nammanoolagam.feature.base.BaseView;

public class UserDetailsView extends BaseView{

	private final UserDetailsModel model;
	private final Scanner scanner = new Scanner(System.in);
	
	public UserDetailsView() {
		
		
		model = new UserDetailsModel(this);
		
	}


	public void init() {
		
		showMenu();
		
	}


	private void showMenu() {
		  while (true) {
            System.out.println("\n=== User Details ===");
            System.out.println("1. View User Details");
            System.out.println("2. Back");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewUserDetails();
                        break;
                    case 2:
                    	
                         return;
                    case 3:
                       logoutApp();
                        return;
                    case 4:
                        exitApp();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
		
	}
	
	 private void viewUserDetails() {
	        System.out.println("\nEnter User ID:");
	        String userId = scanner.nextLine();
	        model.getUserDetails(userId);
	    }


	public void showMessage(String message) {
		
		System.out.println(message);
		
	}


	

	
}
