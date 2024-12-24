package com.thalesbensi.To_Do_List.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thalesbensi.To_Do_List.entities.Authentication;
import com.thalesbensi.To_Do_List.entities.Register;
import com.thalesbensi.To_Do_List.entities.User;
import com.thalesbensi.To_Do_List.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
		
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid Authentication data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build(); 
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid Register data) {
		if(this.userRepository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());		
		User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());
		
		this.userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}
