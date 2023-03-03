package com.customException;

public class InvalidChoiceException extends RuntimeException{
	
public String getMessage;

public InvalidChoiceException(String getMessage) {
	super();
	this.getMessage = getMessage;
}

}
