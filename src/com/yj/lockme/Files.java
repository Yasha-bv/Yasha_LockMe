package com.yj.lockme;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Files {

	public static void listFiles() {

		File fileDir = new File("C:\\Users\\Public\\");
		if (fileDir.isDirectory()) {
			List listFile = Arrays.asList(fileDir.list());
			Collections.sort(listFile);
			System.out.println("---------------------------------------");
			System.out.println("Sorting by filename in ascending order");
			for (Object s : listFile) {
				System.out.println(s.toString());
			}

		} else {
			System.out.println(fileDir.getAbsolutePath() + " is not a directory");
		}
		reUse();
	}

	public static void addFile() {

		String strPath = "", strName = "";

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the file name:");

			strName = br.readLine();
			System.out.println("Enter the file path:");

			strPath = br.readLine();

			File file1 = new File(strPath + "" + strName + ".txt");

			boolean result = file1.createNewFile();

			if (result) {
				System.out.println("file created " + file1.getCanonicalPath());
			} else {
				System.out.println("File already exist at location: " + file1.getCanonicalPath());
			}
			reUse();
		}

		catch (Exception ex1) {
		}
	}

	public static void searchFile() {
		File directory = new File("C://Users//Public//");

		String[] flist = directory.list();
		int flag = 0;
		if (flist == null) {
			System.out.println("Empty directory.");
		} else {
			System.out.println("Enter file name to search:");
			Scanner searchScan = new Scanner(System.in);
			String fileName = searchScan.next();

			for (int i = 0; i < flist.length; i++) {
				String filename = flist[i];
				if (filename.equalsIgnoreCase(fileName)) {
					System.out.println(filename + " found");
					flag = 1;
				}
			}
		}

		if (flag == 0) {
			System.out.println("File Not Found");
		}
		reUse();
	}

	public static void deleteFile() {
		System.out.println("Enter file name to delete:");
		Scanner searchScan = new Scanner(System.in);
		String fileName = searchScan.next();
		File file = new File("C:\\Users\\Public\\" + fileName);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Something went wrong...");
		}
		reUse();
	}

	public static void closeApp() {
		System.out.println("Bye bye...");
		System.exit(1);
	}
	
	public static void reUse() {
		System.out.println("Do you want to continue? (yes/no)");
		Scanner scanAnswer = new Scanner(System.in);
		String answer = scanAnswer.next();
		if (answer.equals("yes")) {
			Application.initApp();
			FileManager.fileManagerOptions();
		} else {
			System.out.println("Thanks for using the LockMe application");
			System.exit(1);
		}
	}

}
