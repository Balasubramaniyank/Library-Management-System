package com.nammanoolagam.feature.users.manage;

import java.util.List;
import java.util.UUID;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.User;

 
public class UserManageModel {
	
	
	UserManageView view;
	
	
	public UserManageModel(UserManageView view) {
		
		this.view = view;
		
	}


	public void addUser(User user) {
	
		
		if(valiateUser(user)) {
			
		  user.setUserId(generateUserId());
		  nammanoolagamDb.getInstance().addUser(user);
		  
		  view.showSuccessMessage("User added successfully!");
			
		}
		else {
			
			 view.showErrorMessage("Invalid user information. Please try again.");
			
		}
		
		
		
	}


	private boolean valiateUser(User user) {
		
		         return user != null &&
	               user.getFirstName() != null && !user.getFirstName().trim().isEmpty() &&
	               user.getLastName() != null && !user.getLastName().trim().isEmpty() &&
	               user.getEmail() != null && user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
	               user.getMobileNumber() != null && user.getMobileNumber().matches("\\d{10}") &&
	               user.getAddress() != null && !user.getAddress().trim().isEmpty() &&
	               user.getDob() != null && user.getDob().matches("\\d{2}/\\d{2}/\\d{4}");
	}
	
	private String generateUserId() {
        return "USR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


	public void viewAllUser() {
		
		List<User> users=nammanoolagamDb.getInstance().getUsers();
		
		view.displayUser(users);
		
	}

}
