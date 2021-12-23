/*
 * This console based application can be used to create the directories & files 
 * and perform various operations on them.
 * 
 * Presently application supports creating files inside the Main Folder. 
 * 
 * Later can be enhanced to create the folders inside the Main Folder.
 * 
 * @author Pankaj Prakash
 * 
 */

package com.pankajfsd.phase1project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = null;
		String tfile = null;
		String fname = null;
		String path = null;
		File file = null;
		File dir = null;

		System.out.println("==============================================================================");
		System.out.println("Welcome to the LockedMe App(the world of Lockers)... Developer: Pankaj Prakash");
		System.out.println("==============================================================================");

		System.out.println();
		System.out.println("Please Enter the name for the Main Folder : (Eg. Main or main) ");
		String folderName = sc.nextLine().toLowerCase();
		dir = new File(folderName);

		if (dir.exists()) {
			System.out.println(folderName + " folder Already Exists. Please continue with the file operations.\n");
		} else {
			System.out.println("Cheers!!! " + folderName + " Folder Created Successfully.\n");
			dir.mkdir();
		}

		loop1: while (true) {
			System.out.println("+++++++++++++++++++");
			System.out.println("Welcome to LockedMe");
			System.out.println("+++++++++++++++++++");
			System.out.println();
			System.out.println(
					"=============================================================================================");
			System.out.println(
					"Application can be used for creating Folder & Files and performing various operations on them");
			System.out.println(
					"=============================================================================================");
			System.out.println();
			System.out.println("Please select the operation which you want to perform");
			System.out.println("=====================================================");
			System.out.println("1. Retrieve Files from Main Folder\n2. File Operations\n3. Exit");

			System.out.println("Please Enter Your Choice :");
			int choice1 = sc.nextInt();

			switch (choice1) {
			case 1:
				File arr[] = dir.listFiles();
				if (arr.length != 0) {
					System.out.println("List of files and folders in the Main Folder are : ");
					for (File f : arr) {
						if (f.isFile()) {
							System.out.println(f);
						} else if (f.isDirectory()) {
							System.out.println(f);
						}
					}
				} else {
					System.out.println(folderName + " Folder is Empty\n");
				}
				break;
			case 2:
				while (true) {
					System.out.println();
					System.out.println("Please select the operation which you want to perform");
					System.out.println("=====================================================");
					System.out.println(
							"1. Add Files to Main Folder\n2. Delete Files from Main Folder\n3. Search Files in Main Folder\n4. Return to Previous Menu\n5. Exit");

					System.out.println("Please Enter Your Choice :");
					int choice2 = sc.nextInt();
					switch (choice2) {
					case 1:
						System.out.println("Please enter the new file name which you want to create : ");
						name = sc.next().toLowerCase();
						tfile = "\\".concat(name);
						fname = tfile.concat(".txt");
						path = dir.getAbsolutePath().concat(fname);

						file = new File(path);

						if (file.exists()) {
							System.out.println(fname + " File Already Exists. Please enter the Unique file name");
						} else {
							try {
								System.out.println(fname + " Created Successfully.");
								file.createNewFile();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

						break;
					case 2:
						System.out.println("Please enter the file name which you want to delete : ");
						name = sc.next().toLowerCase();
						tfile = "\\".concat(name);
						fname = tfile.concat(".txt");
						path = dir.getAbsolutePath().concat(fname);

						file = new File(path);

						if (file.exists()) {
							System.out.println(fname + " deleted successfully.");
							file.delete();
						} else {
							System.out.println(fname + " doesn't exists.");
						}

						break;
					case 3:
						System.out.println("Please enter the file name which you want to search : ");
						fname = sc.next().toLowerCase();
						path = dir.getAbsolutePath();

						file = new File(path);

						File farr[] = file.listFiles();

						loop2: for (File f : farr) {
							if (f.getName().startsWith(fname)) {
								System.out.println(f);
							} else {
								System.out.println(fname + " doesn't exists.");
								break loop2;
							}
						}

						break;
					case 4:
						System.out.println("Returning Back to the Start Menu : ");
						continue loop1;
					case 5:
						System.out.println("Thank You!!! Please Visit Again.");
						System.exit(0);

					default:
						System.out.println("Incorrect Choice!!! Please Enter the Correct Choice.\n");
					}
				}
			case 3:
				System.out.println("Thank You! Please Visit Again.");
				System.exit(0);
			default:
				System.out.println("Incorrect Choice!!! Please Enter the Correct Choice.\n");
			}
		}
	}
}
