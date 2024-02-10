package com.tut.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.model.Register;
import com.tut.repo.RegisterRepo;
import com.tut.service.RegisterInterface;


@Component
public class RegisterServiceImpl implements RegisterInterface {

	@Autowired
	private RegisterRepo resgisteRepo;

	@Override
	public Register registerUser(Register register) throws EmailAlreadyExistsException {
		Register checkExitUser= resgisteRepo.findByEmail(register.getEmail());
		if(checkExitUser!=null) {
			throw new EmailAlreadyExistsException("Email already exists. Please use a different email address.");
		}
		else {
			return this.resgisteRepo.save(register);
		}
		
		

	}

}
