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

import com.tut.Exception.UserNotFoundException;
import com.tut.model.Login;
import com.tut.service.LoginInterface;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginInterface loginInterface;
	@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
	@PostMapping("/user")
	public ResponseEntity<String> logInUser(@RequestBody Login login) {
	    try {
	        this.loginInterface.loginUser(login);
	        return ResponseEntity.ok("Login successful");
	    } catch (UserNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    }
	}


	
}
