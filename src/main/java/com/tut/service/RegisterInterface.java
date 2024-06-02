package com.tut.service;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.dto.RegisterUserDto;
import com.tut.model.Register;

public interface RegisterInterface {

	public Register registerUser(RegisterUserDto register) throws EmailAlreadyExistsException;
	
}
