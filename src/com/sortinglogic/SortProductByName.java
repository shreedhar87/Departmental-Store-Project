package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Product;

public class SortProductByName implements Comparator<Product>{

	@Override
	public int compare(Product x, Product y) {
		return (int) (x.getCost()- (int)y.getCost());
	}

}
