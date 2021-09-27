package com.yj.lockme;

import java.util.Scanner;

public class GetUserCredentials {

	public GetUserCredentials() {

	}

	public static void fetchCredentials(String inpUsername, Scanner lockerInput) {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO DIGITAL LOCKER 	 *");
		System.out.println("*   YOUR CREDS ARE 	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println(inpUsername);

		while (lockerInput.hasNext()) {
			System.out.println(lockerInput.hasNext());
			if (lockerInput.next().equals(inpUsername)) {
				System.out.println("Site Name: " + lockerInput.next());
				System.out.println("User Name: " + lockerInput.next());
				System.out.println("User Password: " + lockerInput.next());
			}
		}

	}
}
