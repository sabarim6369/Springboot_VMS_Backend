package com.example.VMS.Respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.VMS.Modals.visitormodal;

public interface Visitorrepo extends MongoRepository<visitormodal,String>{

}
