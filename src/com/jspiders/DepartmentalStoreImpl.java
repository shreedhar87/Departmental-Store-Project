package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customException.InvalidChoiceException;
import com.customException.ProductNotFoundException;
import com.sortinglogic.SortProductByCost;
import com.sortinglogic.SortProductById;
import com.sortinglogic.SortProductByName;
import com.sortinglogic.SortProductByQuantity;

public class DepartmentalStoreImpl implements DepartmentalStore{
	Scanner scan=new Scanner(System.in);
	Map<String, Product> map=new LinkedHashMap<>();
	@Override
	public void addProduct() {
		/*Accept name, cost, quantity
		 * create an instance of product
		 * Add into map -> put() -> Entry
		 */
		System.out.println("Enter product name");
		String name=scan.next();

		System.out.println("Enter cost");
		Double cost=scan.nextDouble();

		System.out.println("Enter product quantity");
		int quantity=scan.nextInt();

		Product p=new Product(name, cost, quantity );
		map.put(p.getId(), p);

		System.out.println("Product inserted succesfully!\n-----------------------");

	}

	@Override
	public void removeProduct() {
		System.out.println("Enter Product Id");
		String id=scan.next().toUpperCase();
		if(map.containsKey(id)) {
			map.remove(id);
			System.out.println("Product Removed Succesfully\n---------------------");
		}
		else {
			try {
				throw new ProductNotFoundException("product not present");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllProduct() {
		System.out.println(map.size()+" products Available");
		map.clear();
		System.out.println("All the products deleted succesfully!\n--------------------");
	}

	@Override
	public void displayProduct() {
		System.out.println("Enter Product Id");
		String id=scan.next().toUpperCase();
		if(map.containsKey(id)) {
			System.out.println(map.get(id));
			System.out.println("-----------------");
		}
		else {
			try {
				throw new ProductNotFoundException("product not present");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllProduct() {
		Set<String> keys=map.keySet();
		for (String id : keys) {
			System.out.println(map.get(id));
		}
		System.out.println("------------");
	}

	@Override
	public void updateProduct() {
		System.out.println("Enter Product Id");
		String id=scan.next().toUpperCase();
		if(map.containsKey(id)) {
			Product p=map.get(id);
			System.out.println("1.update product name\n2.update product cost\n3.update product quantity\n");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter choice:");
			int choice =scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter product name");
				String name=scan.next();
				p.setName(name);
				System.out.println("Product Name Updated Succesfully\n------------------");
				break;
			case 2:
				System.out.println("Enter cost");
				Double cost=scan.nextDouble();
				p.setCost(cost);
				System.out.println("Product Cost Updated Succesfully\n---------------------");
				break;
			case 3:
				System.out.println("Enter product quantity");
				int quantity=scan.nextInt();
				p.setQuantity(quantity);
				System.out.println("Product Quantity Updated Succesfully\n-------------------");
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid choice!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new ProductNotFoundException("product not present");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countProduct() {
		System.out.println("Products Available: "+map.size()+"\n---------------");
	}

	@Override
	public void sortProduct() {
		Set<String> keys=map.keySet();
		List<Product> l=new ArrayList<Product>();
		for (String key : keys) {
			l.add(map.get(key));
		}
		System.out.println("1.Sort Product By Id\n2.Sort Product By Name\n3.Sort Product By Cost\n4.Sort Product By Quantity");
		Scanner scan=new  Scanner(System.in);
		System.out.println("Enter choice:");
		int choice=scan.nextInt();
		System.out.println("Enter choice:");
		System.out.println("1.Assending\n2.Descending");
		int input=scan.nextInt();

		switch(choice) {
		case 1:
			Collections.sort(l, new SortProductById());
			if(input==2) {
				Collections.reverse(l);
			}
			display(l);
			break;
		case 2:
			Collections.sort(l, new SortProductByName());
			if(input==2) {
				Collections.reverse(l);
			}
			display(l);
			break;
		case 3:
			Collections.sort(l, new SortProductByCost());
			if(input==2) {
				Collections.reverse(l);
			}
			display(l);
			break;
		case 4:
			Collections.sort(l, new SortProductByQuantity());
			if(input==2) {
				Collections.reverse(l);
			}
			display(l);
			break;
		default:
			try {
				throw new ProductNotFoundException("Invalid Choice\n----------------------------");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("----------------------");
	}
	private static void display(List<Product> l){
		for (Product p : l) {
			System.out.println(p);
		}
	}
}
