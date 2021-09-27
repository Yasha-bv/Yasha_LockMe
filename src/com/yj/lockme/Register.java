package com.yj.lockme;

import java.io.PrintWriter;
import java.util.Scanner;

import com.yj.lockme.model.Users;

public class Register {

	public Register() {
	}

	public static void registerUser(Users users, Scanner keyboard, PrintWriter output, Scanner input, boolean initialLoad) {
		if(initialLoad) {
			System.out.println("==========================================");
			System.out.println("*					*");
			System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
			System.out.println("*					*");
			System.out.println("==========================================");
		}
		System.out.println("Enter Username :");
		String username = keyboard.next();
		users.setUsername(username);
	
		if (!isUserExist(input, username)) {
			System.out.println("Enter Password :");
			String password = keyboard.next();
			users.setPassword(password);
			output.println(users.getUsername());
			output.println(users.getPassword());

			System.out.println("User Registration Successful !!!");
			output.close();
			System.out.println("Do you want to continue? (yes/no)");
			Scanner scanAnswer = new Scanner(System.in);
			String answer = scanAnswer.next();
			if (answer.equals("yes")) {
				Application.signInOptions();
			} else {
				System.out.println("Thanks for using the LockMe application");
				System.exit(1);
			}
		} else {
			System.out.println("User Exist! Please enter another username");
			registerUser(users, keyboard, output, input, false);
		}
	}

	public static boolean isUserExist(Scanner input, String inputUName) {
		
		boolean found = false;
		while (input.hasNext() && !found) {
			
			if (input.next().equals(inputUName)) {
			found = true;
			}
		}
		return found;
	}
}
