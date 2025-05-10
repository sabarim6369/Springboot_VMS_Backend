package com.example.VMS.Respository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.VMS.Modals.Authmodal;


public interface Authrepo extends MongoRepository<Authmodal,String>{
	

}
