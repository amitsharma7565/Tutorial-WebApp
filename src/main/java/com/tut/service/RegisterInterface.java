package com.tut.service;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.model.Register;

public interface RegisterInterface {

	public Register registerUser(Register register) throws EmailAlreadyExistsException;
	
}
