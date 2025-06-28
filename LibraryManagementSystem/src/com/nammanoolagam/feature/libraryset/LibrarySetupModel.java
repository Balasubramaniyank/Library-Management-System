package com.nammanoolagam.feature.libraryset;

import com.nammanoolagam.repository.db.nammanoolagamDb;
import com.nammanoolagam.repository.dto.Library;

public class LibrarySetupModel {

	
	LibrarySetupView view;
	
	public LibrarySetupModel(LibrarySetupView view) {
		
		
		this.view=view;
	}

	public void init() {
	
		
		if(nammanoolagamDb.getInstance().getLibrary()==null) {
			
			view.proceedToSetupLibrary();
		}
		else {
			
	  
		}
		
	}

	public void setUpLibrary(Library library) {
		
		
		if(ValidateLibrary(library)) {
			
		 
			nammanoolagamDb.getInstance().setLibrary(library);
			
			view.onLibrarySetupCompleted();
			
		}
		
		
	}

	private boolean ValidateLibrary(Library library) {
		
		return library.getName()!= null && 
			   library.getAddress()!= null &&
			   library.getCapacity()!=null &&
			   library.getEmailId()!=null &&
			   library.getIncharge()!=null &&
			   library.getOpeningTime()!=null &&
			   library.getClosingTime()!=null &&
			   library.getNoAvailableDays()!=null &&
			   library.getPhoneNo()!=null;
		
			   
			   
				
	}
	
	
}
