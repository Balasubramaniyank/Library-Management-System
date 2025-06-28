package com.nammanoolagam.feature.users.details;

import java.util.List;
import java.util.Optional;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.User;

public class UserDetailsModel {

	
	UserDetailsView view;
	
	public  UserDetailsModel (UserDetailsView view) {
		
		
		this.view = view;
	}

	public void getUserDetails(String userId) {
		
		
		if(userId.trim().isEmpty() || userId==null) {

			view.showMessage("Please enter a valid User ID.");
			
		}
		else {
			
			Optional<User> users =nammanoolagamDb.getInstance().getUsers().stream()
					          .filter(a->a.userId.equals(userId))
					          .findFirst();
					          
					          
			
		}
		
	}
	
}
