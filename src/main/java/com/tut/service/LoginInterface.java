package com.tut.service;

import com.tut.Exception.UserNotFoundException;
import com.tut.model.Login;

public interface LoginInterface {
	
	public void loginUser(Login login) throws UserNotFoundException;
}
