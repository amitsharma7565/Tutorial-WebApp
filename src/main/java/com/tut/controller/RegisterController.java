package com.tut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tut.model.Register;
import com.tut.service.RegisterInterface;

@RestController
@RequestMapping("/tutApp")
public class RegisterController {
	
	@Autowired
	RegisterInterface registerInterface;
	
	@PostMapping("/create")
	public ResponseEntity<Register> registerUser( @RequestBody Register register){
		Register registerResponse =this.registerInterface.registerUser(register);
		return new ResponseEntity<Register>(registerResponse, HttpStatus.CREATED) ;
	}
}
