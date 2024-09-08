package com.Assignement.Abc_backend.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignement.Abc_backend.Model.Product;

public interface productRepository extends MongoRepository<Product, ObjectId> {

    List<Product> findByCategory(String category);

}
