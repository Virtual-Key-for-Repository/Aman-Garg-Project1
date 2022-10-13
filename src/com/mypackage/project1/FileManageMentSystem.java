package com.mypackage.project1;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManageMentSystem {

	public static void main(String[] args) throws IOException {
	System.out.println("WELCOME TO VIRTUAL KEY FOR YOUR REPOSITORIES");
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	System.out.println("Application Name:LOCKED.IN");
	System.out.println("Developer Name:Aman Garg");
	System.out.println("Directory Path : D:\\\\project1phase1Directory ");
	final String location = "D:\\project1phase1Directory";
	do {
		System.out.println("File Menu");
		System.out.println("-------------------------");
		System.out.println("1)List Filenames In Ascending Order");
		System.out.println("2)User Interaction Options");
		System.out.println("3)EXIT");
		System.out.println("-------------------------");
		System.out.print("Enter your choice: ");
		try {
			choice = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Only number Allowed");
			continue;
	}
		System.out.println("-------------------------");
		switch(choice) {
		case 1:
			System.out.println("File And Directory List In Ascending Order");
			System.out.println();
			try {
			File file = new File(location);
            File filedirec [] = file.listFiles();
            Arrays.sort(filedirec);
            for(File e : filedirec) {
            	if (e.isFile()) {
            		System.out.println("File:" + e.getName());
            		System.out.println();
            	}
            	else if (e.isDirectory()) {
            		System.out.println("Directory:" + e.getName());
            		System.out.println();
            	}	
            	else {
            		System.out.println("Not Known:" + e.getName());
            		System.out.println();
            	}		
            }
			}
			catch(Exception e) {
				System.err.println("Directory Path must be present to do this operation :");
				System.err.println("Directory Path : D:\\\\project1phase1Directory ");
			}
			break;
			
		case 3:
			System.out.println("Thank You For Using App");
			break;
		default:
			System.out.println("Invalid Option : Try Again");	
		}	
	}while(choice!=3);
	scanner.close();
	}
	
	
	
}
