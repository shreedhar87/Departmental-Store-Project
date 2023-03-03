package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Product;

public class SortProductByQuantity implements Comparator<Product>{

	@Override
	public int compare(Product x, Product y) {
		return x.getQuantity()-(y.getQuantity());
	}


}
