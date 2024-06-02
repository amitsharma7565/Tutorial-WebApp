package com.tut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tut.Exception.EmailAlreadyExistsException;
import com.tut.dto.LoginResponse;
import com.tut.dto.LoginUserDto;
import com.tut.dto.RegisterUserDto;
import com.tut.model.Register;
import com.tut.security.JwtService;
import com.tut.service.RegisterInterface;
import com.tut.serviceImpl.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class RegiterLoginController {

	@Autowired
	RegisterInterface registerInterface;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationService authenticationService;

	@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
	@PostMapping("/signUp")
	public ResponseEntity<Register> registerUser(@RequestBody RegisterUserDto register) {
		Register registerResponse = authenticationService.signup(register);
		return ResponseEntity.ok(registerResponse);
	}

	@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> logInUser(@RequestBody LoginUserDto login) {
		try {
			Authentication authenticatedUser = authenticationService.authenticate(login);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			String jwtToken = jwtService.generateJwtToken(authenticatedUser);
			Register userDetails = (Register) authenticatedUser.getPrincipal();
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setToken(jwtToken);

			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue()); // Disable caching
			headers.set("Authorization", "Bearer " + jwtToken);

			return ResponseEntity.ok(loginResponse);
		} catch (LockedException ex) {
			return ResponseEntity.status(HttpStatus.LOCKED).body(new LoginResponse("User account is locked"));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Invalid login credentials"));
		}
	}

}
