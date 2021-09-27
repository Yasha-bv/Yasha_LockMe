package com.yj.lockme;

import java.io.PrintWriter;
import java.util.Scanner;

import com.yj.lockme.model.Credentials;

public class Store {

	public Store() {
		
	}
	public static void storeCredentials(String loggedInUser, Credentials userCredentials, Scanner keyboard, PrintWriter lockerOutput) {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   Welcome to Locker, Store your Credentials here	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		
		userCredentials.setLoggedInUser(loggedInUser);
		
		System.out.println("Enter Site Name :");
		String siteName = keyboard.next();
		userCredentials.setSiteName(siteName);
		
		System.out.println("Enter Username :");
		String username = keyboard.next();
		userCredentials.setUsername(username);
		
		System.out.println("Enter Password :");
		String password = keyboard.next();
		userCredentials.setPassword(password);
		
		lockerOutput.println(userCredentials.getLoggedInUser());
		lockerOutput.println(userCredentials.getSiteName());
		lockerOutput.println(userCredentials.getUsername());
		lockerOutput.println(userCredentials.getPassword());
		
		System.out.println("YOUR CREDS ARE STORED AND SECURED!");
		lockerOutput.close();		
	}
}
