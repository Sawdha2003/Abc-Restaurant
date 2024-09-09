package com.Assignment.Abc_Restaurant.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignment.Abc_Restaurant.Model.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByUsername(String username);

    Optional<User> findByRole(String role);

    boolean existsById(ObjectId id);
    
    void deleteById(ObjectId id);
}
