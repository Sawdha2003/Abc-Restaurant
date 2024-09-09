package com.Assignment.Abc_Restaurant.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignment.Abc_Restaurant.Dinein;

public interface DineinRepository extends MongoRepository<Dinein, ObjectId> {

    List<Dinein> findByStatus(String Status);


}
