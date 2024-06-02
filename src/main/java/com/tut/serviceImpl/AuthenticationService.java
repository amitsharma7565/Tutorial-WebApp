package com.tut.serviceImpl;

import com.tut.dto.LoginUserDto;
import com.tut.dto.RegisterUserDto;
import com.tut.model.Register;
import com.tut.repo.RegisterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	@Autowired
	private final RegisterRepo userRepository;

	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(RegisterRepo userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Register signup(RegisterUserDto input) {
		
		
		
		Register user= new Register();
		user.setFirstName(input.getFirstName());
		user.setLastName(input.getLastName());
		user.setEmail(input.getEmail());
		user.setPassword(passwordEncoder.encode(input.getPassword()));

		return userRepository.save(user);
	}

	public Authentication authenticate(LoginUserDto input) {
		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

	}
}