package com.tut.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.dto.RegisterUserDto;
import com.tut.model.Register;
import com.tut.repo.RegisterRepo;
import com.tut.service.RegisterInterface;


@Component
public class RegisterServiceImpl implements RegisterInterface {

	@Autowired
	private RegisterRepo resgisteRepo;



	@Override
	public Register registerUser(RegisterUserDto register) throws EmailAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

}
