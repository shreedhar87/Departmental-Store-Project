package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Product;

public class SortProductById implements Comparator<Product>{

	@Override
	public int compare(Product x, Product y) {
		return x.getId().compareTo(y.getId());
	}

}
