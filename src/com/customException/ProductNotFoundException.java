package com.customException;

public class ProductNotFoundException extends RuntimeException{
String getMessage;

public ProductNotFoundException(String getMessage) {
	super();
	this.getMessage = getMessage;
}

}
