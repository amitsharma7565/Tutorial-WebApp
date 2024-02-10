package com.tut.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tut.Exception.UserNotFoundException;
import com.tut.model.Login;
import com.tut.model.Register;

import com.tut.repo.RegisterRepo;
import com.tut.service.LoginInterface;


@Component
public class LoginServiceImpl implements LoginInterface {

	@Autowired
    private RegisterRepo registerRepo;


	@Override
	public void loginUser(Login login) throws UserNotFoundException {
		Register user=  registerRepo.findByEmail(login.getEmail());
      if(user==null||!user.getPassword().equals(login.getPassword())) {
    	  throw new UserNotFoundException("Invalid email and password");
      }
      else {
    	  System.out.println("user login sucessFully");
      }
	}

	



}
