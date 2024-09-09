package com.Assignment.Abc_Restaurant.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Assignment.Abc_Restaurant.Model.Product;

public interface productRepository extends MongoRepository<Product, ObjectId> {

    List<Product> findByCategory(String category);

}
