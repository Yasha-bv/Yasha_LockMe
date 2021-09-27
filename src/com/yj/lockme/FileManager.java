package com.yj.lockme;

import java.util.Scanner;

public class FileManager {

	private static Scanner keyboard;
	private static Scanner input;
	
	public FileManager() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void fileManagerOptions() {
		keyboard = new Scanner(System.in);
		input = new Scanner(System.in);
		System.out.println("1 . List Files ");
		System.out.println("2 . Add File ");
		System.out.println("3 . Search File ");
		System.out.println("4 . Delete File ");
		System.out.println("5 . Close App ");
		int option = keyboard.nextInt();
		switch(option) {
			case 1 : 
				Files.listFiles();
				break;
			case 2 :
				Files.addFile();
				break;
			case 3 :
				Files.searchFile();
				break;
			case 4 :
				Files.deleteFile();
				break;
			case 5 :
				Files.closeApp();
				break;
			default :
				System.out.println("Please select at least one option");
				break;
		}
		keyboard.close();
		input.close();
	}

}
