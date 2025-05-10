package com.example.VMS.services;

import java.util.List;

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
	

}
