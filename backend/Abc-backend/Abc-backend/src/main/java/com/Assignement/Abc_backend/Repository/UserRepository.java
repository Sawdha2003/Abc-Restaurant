package com.Assignement.Abc_backend.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignement.Abc_backend.Model.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {


    Optional<User> findByUsername(String Username);
}
