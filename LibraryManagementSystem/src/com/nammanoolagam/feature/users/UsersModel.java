package com.nammanoolagam.feature.users;

import java.util.List;

import com.nammanoolagam.feature.users.*;
import com.nammanoolagam.repository.dto.User;
import com.nammanoolagam.repository.db.*;

public class UsersModel {
	
	
	private final UsersView view;
	
	public UsersModel(UsersView view) {
		
		this.view = view;
		
		
	}

	public void listAllUsers() {
		
		List<User> users = nammanoolagamDb.getInstance().getUsers();
        view.displayUsers(users);
		
	}
	

}
