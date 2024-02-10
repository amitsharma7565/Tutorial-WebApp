package com.tut.Exception;

public class EmailAlreadyExistsException extends Exception{

	public EmailAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
}
