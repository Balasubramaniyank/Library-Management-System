package com.nammanoolagam.feature.registration;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.RegistrationInfo;

public class RegistrationModel {
	
	
	RegistrationPresenter presenter ;
	
	public RegistrationModel(RegistrationPresenter  presenter ) {
		
		this.presenter=presenter;
		
	}

	
	
	void init() {
		
		
		if(nammanoolagamDb.getInstance().getRegistrationInfo()!=null) {
			presenter.proceedLogin();
			
		}
		else {
			
			presenter.proceedRegistration();
		}
		
	}

	void RegisterUser(RegistrationInfo info) {
		
      if(validRegister(info)) {
    	  
    	  nammanoolagamDb.getInstance().setRegistrationInfo(info);
    	  presenter.registrationSuccess();
    	  
    	  presenter.proceedLogin();
    	  
      }
      else {
    	  
    	  presenter.proceedRegistration();
      }
		
	}



	private boolean validRegister(RegistrationInfo info) {
		
		return  info.getFirstName()!=null &&
				info.getLastName()!=null&&
				info.getUserName()!=null &&
				info.getLibrarianId()!=null&&
				info.getPassword()!=null&&
				info.getMobileNo()!=null;
				
	}



	public void validateCredentials(String userName, String password) {
		
		if(nammanoolagamDb.getInstance().validateCredentials(userName,password)) {
			
			presenter.onSucessfullyLogin(userName);
			
		}
		else {
			
			presenter.inValidateCredentials();
		}
	
		
	}
	
	
	
	
	
}
