package com.example.VMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VMS.Modals.visitormodal;
import com.example.VMS.Respository.Visitorrepo;
@Service
public class Visitorservice {
	@Autowired
	Visitorrepo visitor;
	public boolean registervisitor(visitormodal visitordata) {
		visitor.save(visitordata);
		return true;
	}
	public boolean checkotp(int otpnumber) {
		return true;
		
	}
	public List<visitormodal> getallvisitor(){
		return visitor.findAll();
	}
	public boolean editvisitor(visitormodal data, String id) {
    Optional<visitormodal> isthere = visitor.findById(id);
    if (isthere.isPresent()) {
    	System.out.println("😍😍😍😍😍😍"+isthere);
        visitormodal existingvisitor = isthere.get();
        System.out.println(existingvisitor.getName());

        if (data.getName() != null) {
            existingvisitor.setName(data.getName());
        }
        if (data.getAge() != 0) {
            existingvisitor.setAge(data.getAge());
        }
        if (data.getNumber() != null) {
            existingvisitor.setNumber(data.getNumber());
        }
        if (data.getPhoto() != null) {
            existingvisitor.setPhoto(data.getPhoto());
        }
        if (data.getAddress() != null) {
            existingvisitor.setAddress(data.getAddress());
        }
        if (data.getCompanions() != null) {
            existingvisitor.setCompanions(data.getCompanions());
        }

        visitor.save(existingvisitor);  
        return true;
    }
    return false; 
}

	

}
