package com.example.VMS.Modals;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;
@Document
public class Authmodal {
	private int age;
	private String name;
	private String address;
	private String email;
	private List<Integer>ls;
	private String password;
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Integer> getLs() {
		return ls;
	}
	public void setLs(List<Integer> ls) {
		this.ls = ls;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
