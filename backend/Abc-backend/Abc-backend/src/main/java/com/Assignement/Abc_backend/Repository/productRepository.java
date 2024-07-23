package com.Assignement.Abc_backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignement.Abc_backend.Model.Product;

public interface productRepository extends MongoRepository<Product, ObjectId> {

}
