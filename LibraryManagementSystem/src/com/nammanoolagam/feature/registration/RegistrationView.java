package com.nammanoolagam.feature.registration;

import java.util.Scanner;

import com.nammanoolagam.feature.base.BaseView;
import com.nammanoolagam.feature.libraryset.LibrarySetupView;
import com.nammanoolagam.repository.dto.RegistrationInfo;

public class RegistrationView extends BaseView {

	RegistrationPresenter presenter;
	
//	private final RegistrationPresenter presenter;

//	public RegistrationView() {
//
//		presenter = new RegistrationModel(this);
//	}
	
	
	public RegistrationView() {		
		
		presenter=new RegistrationPresenter(this);
		
}
	
	
	
	public void init() {

		presenter.init();

	}

	Scanner scanner = new Scanner(System.in);

	void proceedRegistration() {

		RegistrationInfo info = new RegistrationInfo();

		System.out.println("Welcome to Registration Page");

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter the FirstName");

		info.setFirstName(scanner.nextLine());

		System.out.println("Enter the LastName");

		info.setLastName(scanner.nextLine());

		info.setEmailId(getEmailId());
		info.setUserName(getUserName());

		info.setPassword(getPassword());

		info.setMobileNo(getMobile());

		String librarianId = info.getFirstName().charAt(0) + "" + info.getLastName().charAt(0) + ""
				+ (Math.random() * 1000);

		// System.out.println(librarianId.substring(0,5).toUpperCase());

		info.setLibrarianId(librarianId.substring(0, 5).toUpperCase());

//	  System.out.println("Enter the ConfirmPassword");
//	  
//	  info.setConfirmPassword(scanner.nextLine());	  
		// info.setMobileNo(scanner.nextLong());

		presenter.RegisterUser(info);

	}

	private String getMobile() {

		String moblieNumber;
		System.out.println("Enter the MoblieNumber");

		String regex = "^[6-9]\\d{9}$";

		do {

			moblieNumber = scanner.nextLine();

			if (!moblieNumber.matches(regex)) {

				System.out.println("Enter the Valid Mobile Number");
			} else
				break;
		} while (true);

		return moblieNumber;
	}

	private String getPassword() {

		String passWord = "";
		System.out.println("Enter the PassWord");

		do {

			passWord = scanner.nextLine();

			if (passWord.length() < 3 || passWord.length() > 20) {

				System.out.println("Password should not be empty and length min 8 and max 32\n\nEnter valid password:");

			} else
				break;

		} while (true);

		System.out.println("Enter the confirm Password");
		String confirmPassword = "";

		do {

			confirmPassword = scanner.nextLine();

			if (!passWord.equals(confirmPassword)) {

				System.out.println("PassWord MisWatch Try Again !");

			} else
				break;

		} while (true);

		return passWord;

	}

	private String getEmailId() {

		String emailId = "";
		System.out.println("Enter the Email ID");
		do {

			emailId = scanner.nextLine();
			String regex = "^[A-Za-z0-9+_.-]+@(.+)+$";
			if (!emailId.matches(regex)) {

				System.out.println("Invalid Email id! \nEnter the Valid Email id");
			} else
				break;
		} while (true);
		return emailId;
	}

	private String getUserName() {

		String userName = "";

		System.out.println("Enter the UserName");

		do {

			userName = scanner.nextLine();
			if (userName.length() < 3 || userName.length() > 20) {

				System.out.println("User Id Invalid \n Enter the valid UserName");

			} else
				break;

		} while (true);
		return userName;
	}

	public void AlreadyUser(String message) {

		System.out.println(message);

		proceedRegistration();
	}

	public void isWeakPassword(String message) {

		System.out.println(message);
		proceedRegistration();

	}

	public void inValidUserName(String string) {
		System.out.println(string);

		proceedRegistration();

	}

	public void registrationSuccess() {

		System.out.println("Registration SuccessFully");

	}

	public void proceedLogin() {

		System.out.println("Do you want to proceed to login? Y/N");

		String chioce = scanner.nextLine();

		if (chioce.equalsIgnoreCase("y")) {

			presenter.validateCredentials(getUserName(), getPasswordForLogin());

		} else {

			exitApp();
		}

	}

	public void onSucessfullyLogin(String userName) {
		System.out.println("Logged in successfully!");
		System.out.println("Welcome " + userName);

		new LibrarySetupView().init();

	}

	public void inValidateCredentials() {
		System.out.println("Username and password did not match");
		System.out.println("Do you want to proceed? Type Y or N");

		if (scanner.nextLine().equalsIgnoreCase("Y")) {
			proceedLogin();
		}

	}

	private String getPasswordForLogin() {
		String password = "";

		System.out.println("Enter the Password : ");

		do {
			password = scanner.nextLine();
			if (password.length() < 8 || password.length() > 20) {
				System.out.println("Enter the valid Password");
			} else
				break;

		} while (true);

		return password;
	}

}
