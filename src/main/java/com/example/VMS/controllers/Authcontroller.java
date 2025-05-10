package com.example.VMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VMS.Modals.Authmodal;
import com.example.VMS.services.Authservices;
@RestController
@RequestMapping("/auth")
public class Authcontroller {
	@Autowired
	private Authservices authservice;
	
	@PostMapping("/login")
    public ResponseEntity<String> logincontroller(@RequestBody Authmodal authmodal) {
        try {
            boolean isValid = authservice.login(authmodal);
            if (isValid) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Some error occurred");
        }
    }
	@PostMapping("/signup")
	public ResponseEntity<String> signupcontroller(@RequestBody Authmodal authmodal) {
        try {
            boolean isSuccess = authservice.signup(authmodal);
            if (isSuccess) {
                return ResponseEntity.ok("Signup successful");
            } else {
                return ResponseEntity.status(400).body("Signup failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Some error occurred"+e);
        }
    }
	@GetMapping("/dummy")
	private String dummyfun() {
		return "hellow";
	}
	

}
