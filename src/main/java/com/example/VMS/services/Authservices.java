package com.example.VMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.VMS.Modals.Authmodal;
import com.example.VMS.Respository.Authrepo;
@Service
public class Authservices {
@Autowired
Authrepo authrepo;
public boolean login(Authmodal authmodal) {
    String email = authmodal.getEmail();
    String password = authmodal.getPassword();

    
    List<Authmodal> users = authrepo.findAll();
    for (Authmodal user : users) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return true;
        }
    }
    return false;
}

public boolean signup(Authmodal modal) {
	String email=modal.getEmail();
//	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//	String password=encoder.encode(modal.getPassword());
	List<Authmodal>data=authrepo.findAll();
	for(Authmodal user:data) {
		if(user.getEmail().equals(email)) {
			return false;
		}
	}
//modal.setPassword(password);
	authrepo.save(modal);
	return true;
}
}
