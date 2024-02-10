package com.tut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.model.Register;
import com.tut.service.RegisterInterface;

@RestController
@RequestMapping("/tutApp")
public class RegisterController {
	
	@Autowired
	RegisterInterface registerInterface;
	@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
	@PostMapping("/create")
	public ResponseEntity<Register> registerUser( @RequestBody Register register){
		  try {
	            Register registerResponse = registerInterface.registerUser(register);
	            return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
	        } catch (EmailAlreadyExistsException e) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	        }
	}
}
