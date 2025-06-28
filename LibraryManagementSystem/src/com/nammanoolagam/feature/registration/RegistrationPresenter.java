package com.nammanoolagam.feature.registration;

import com.nammanoolagam.repository.dto.RegistrationInfo;

public class RegistrationPresenter {
	
	private final RegistrationModel model;
	private final RegistrationView view;
	

	public RegistrationPresenter(RegistrationView registrationView) {
		
		 view = registrationView;
		 model = new RegistrationModel(this);
		 
		
	}


	 public  void init() {
		
		model.init();
	}


	public void RegisterUser(RegistrationInfo info) {
		
		model.RegisterUser(info);
		
	}


	public void validateCredentials(String userName, String passwordForLogin) {
		
		
		model.validateCredentials(userName, passwordForLogin);
		
	}


	public void proceedLogin() {
		
		
		
		
	}


	public void proceedRegistration() {
		
		
	}


	public void registrationSuccess() {
		
		
	}


	public void onSucessfullyLogin(String userName) {
		
	}


	public void inValidateCredentials() {
		
		
	}

	
	
	
	
	
	
	
}
