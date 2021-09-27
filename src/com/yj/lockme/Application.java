package com.yj.lockme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.yj.lockme.model.Credentials;
import com.yj.lockme.model.Users;

public class Application {

	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner lockerInput;

	private static PrintWriter output;
	private static PrintWriter lockerOutput;

	private static Users users;
	private static Credentials userCredentials;

	public static void main(String[] args) {
		initApp();
		welcomeScreen();
		signInOptions();

	}

	public static void signInOptions() {
		System.out.println("1 . Registration ");
		System.out.println("2 . Login ");
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			Register.registerUser(users, keyboard, output, input, true);
			break;
		case 2:
			Login.loginUser(input, keyboard);
			break;
		default:
			System.out.println("Please select 1 Or 2");
			break;
		}
		keyboard.close();
		input.close();
	}

	public static void lockerManager(String inpUsername) {
		System.out.println("1 . Fetch all Stored Credentials ");
		System.out.println("2 . Stored Credentials ");
		System.out.println("3 . Handling of Files ");
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			GetUserCredentials.fetchCredentials(inpUsername, lockerInput);
			break;
		case 2:
			Store.storeCredentials(inpUsername, userCredentials, keyboard, lockerOutput);
			break;
		case 3:
			FileManager.fileManagerOptions();
			break;
		default:
			System.out.println("Please select 1, 2 or 3");
			break;
		}
		lockerInput.close();
	}

	public static void welcomeScreen() {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   Welcome To LockedMe.com		*");
		System.out.println("*   Your Personal Digital Locker	*");
		System.out.println("*					*");
		System.out.println("*	Developer Name - Yasha J		*");
		System.out.println("*	Email - yasha@comviva.com		*");
		System.out.println("*					*");
		System.out.println("==========================================");

	}

	public static void initApp() {

		File userdb = new File("userdb.txt");
		File secret = new File("secret.txt");

		try {

			input = new Scanner(userdb);

			lockerInput = new Scanner(secret);

			keyboard = new Scanner(System.in);

			output = new PrintWriter(new FileWriter(userdb, true));
			lockerOutput = new PrintWriter(new FileWriter(secret, true));

			users = new Users();
			userCredentials = new Credentials();

		} catch (IOException e) {
			System.out.println("404 : File Not Found ");
		}

	}

}
