package com.example.VMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VMS.Modals.visitormodal;
import com.example.VMS.services.Visitorservice;
@RestController

@RequestMapping("/visitor")
public class Visitorcontroller {
	@Autowired
	Visitorservice visitorservice;
@GetMapping("/getallvisitor")
private ResponseEntity<List<visitormodal>> getallvisitorcontroller(){
	List<visitormodal>data=visitorservice.getallvisitor();
	return ResponseEntity.status(200).body(data);
}
@PostMapping("/addvisitor")
private ResponseEntity<String> registervisitor(@RequestBody visitormodal visitor) {
    try {
        boolean isRegistered = visitorservice.registervisitor(visitor);
        return ResponseEntity.status(201).body("Registered successfully");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
    }
}
@PostMapping("/updatevisitor/{id}")
private ResponseEntity<String> updatevisitor(@RequestBody visitormodal modal,@PathVariable String id){
	try {
		boolean issuccess=visitorservice.editvisitor(modal,id);
		if(issuccess) {
			return ResponseEntity.status(200).body("Edited successfully");
		}
		else {
            return ResponseEntity.status(404).body("Visitor with ID " + id + " not found");
		}
	}
	catch(Exception e) {
		return ResponseEntity.status(500).body("Updation failed"+e.getMessage());
	}
}

}
