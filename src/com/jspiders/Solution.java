package com.jspiders;

import java.util.Scanner;

import com.customException.InvalidChoiceException;

public class Solution {
	private static void displayMenu() {
		System.out.println("1.Add Product\n2.Display Product\n3.Display All Product\n4.Remove Product\n5.Remove All Product\n6.Update Product\n7.Count Product\n8.Sort Products\n9.EXIT");

	}
public static void main(String[] args) {
	//Menu Driven program -> 9 options
	// switch
	// com.customException -> InvalidChoiceException
	DepartmentalStore store=new DepartmentalStoreImpl();
	Scanner scan=new Scanner(System.in);
	System.err.println("Welcome to Departmental Store\n-----------------------------");
	while(true) {
	displayMenu();
	System.out.println("----------");
	System.out.println("Enter choice:");
	int choice=scan.nextInt();
	switch(choice){
	case 1:
		store.addProduct();
		break;
	case 2:
		store.displayProduct();
		break;
		
	case 3:
		store.displayAllProduct();
		break;
	case 4:
		store.removeProduct();
		break;
	case 5:
		store.removeAllProduct();
		break;
	case 6:
		store.updateProduct();
		break;
	case 7:
		store.countProduct();
		break;
	case 8:
		store.sortProduct();
		break;
	case 9:
		System.out.println("THANK YOU!");
		System.exit(0);
		default:
			try {
				throw new InvalidChoiceException("Invalid choice!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	}
}
}
