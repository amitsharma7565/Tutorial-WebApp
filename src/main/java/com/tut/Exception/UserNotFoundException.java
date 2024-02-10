package com.tut.Exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
