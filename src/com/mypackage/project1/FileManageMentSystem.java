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
		case 2:
			int subchoice = 0;
			do {
			System.out.println();
			System.out.println("User Interaction Options:");
			System.out.println("-------------------------");
			System.out.println("1)Add File");
			System.out.println("2)Delete File");
			System.out.println("3)Search FIle");
			System.out.println("4)Main Menu");
			System.out.println("-------------------------");
			System.out.print("Enter your choice: ");

			try {
				subchoice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("only numbers allowed");
				continue;
			}
			
			System.out.println("-------------------------");
			System.out.println();
			
			switch(subchoice) {
			
			case 1:
				System.out.print("Enter the file Name to be add : ");
				String fileName = scanner.nextLine().toLowerCase();
				try {
				Path path = Paths.get("D:\\project1phase1Directory\\"+fileName+".txt");
				if(Files.exists(path)) {
					System.out.println("Already this File name exists");
				}
				else {
					Path pathdone = Files.createFile(path);
					System.out.println("File is created :" + pathdone.toString());
				}
				
				}
				catch(Exception e) {
					e.printStackTrace();
					continue;
				}
				break;
				
			case 2:
				System.out.print("Enter the file Name to be deleted : ");
				String fileName2 = scanner.nextLine();
				try {
				Path path = Paths.get("D:\\project1phase1Directory\\"+fileName2+".txt");
				if(Files.exists(path)) {
					  Files.delete(path);
					  System.out.println("File Deleted Successfully");
				}
				else {	
					System.out.println("File Not Available");	
				}
				
				}
				catch(Exception e) {
					e.printStackTrace();
					continue;
				}
				break;		
			case 3:
				boolean flag = false;
				System.out.print("Enter the filename to be search :  ");
				String fileName3  = scanner.nextLine().toLowerCase();
				File file = new File(location);
				File filedirec[] = file.listFiles();
				for(int i=0; i<filedirec.length; i++) {
					if(filedirec[i].getName().startsWith(fileName3)) {
						System.out.println(filedirec[i].toString());
						flag = true;
					}
				}
				if(flag==false) {
					System.out.println("File not Found");
				}	
				break;
			case 4:
				System.out.println("Returning To The Main Menu");
				break;
				
			default:
				System.out.println("Invaid Option : Try Again");	
		}
			}while(subchoice!=4);
			
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
