package com.jspiders;

public class Product {
/*private -> id(Auto-generated), name, cost, quantity.
 * public constructor
 * 4 public getter() & 3 public setter()
 * toString()
 */
	private String id;
	private String name;
	private double cost;
	private int quantity;
	
	private static int count =101;
	
	public Product(String name, double cost, int quantity) {
		this.id = "JSP"+count;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	
}
