package com.Assignment.Abc_Restaurant.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignment.Abc_Restaurant.Model.Contact;

public interface QueryRepository extends MongoRepository<Contact, String>{

    

    

}
