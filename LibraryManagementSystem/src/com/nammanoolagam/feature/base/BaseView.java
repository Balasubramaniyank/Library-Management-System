package com.nammanoolagam.feature.base;

import com.nammanoolagam.feature.registration.RegistrationView;

public abstract class BaseView {

	
	protected void logoutApp() {
		
		System.out.println("Logged out Successfully");
		
		new RegistrationView().init();
		
	}
	
	
	 protected void exitApp() {
		 System.out.println("Thank You for Using Nammanoolagam");
		 System.exit(0);
		}
}
