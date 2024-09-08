package com.Assignement.Abc_backend.Repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignement.Abc_backend.Dinein;

public interface DineinRepository extends MongoRepository<Dinein, ObjectId> {

    List<Dinein> findByStatus(String Status);

    public Object findBy(int id);

    Optional<Dinein> findById(String id);


}
