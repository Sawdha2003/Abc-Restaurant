package com.Assignement.Abc_backend.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignement.Abc_backend.Dinein;

public interface DineinRepository extends MongoRepository<Dinein, ObjectId> {

    List<Dinein> findByStatus(String Status);


}
