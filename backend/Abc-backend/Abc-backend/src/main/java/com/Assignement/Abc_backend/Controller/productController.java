package com.Assignement.Abc_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignement.Abc_backend.Model.Product;
import com.Assignement.Abc_backend.Service.ProductService;

@RestController
@RequestMapping("/products")
public class productController {

@Autowired
ProductService productservice;

@GetMapping
public ResponseEntity<List<Product>> getAllProducts(){

    return new ResponseEntity<>(productservice.allProduct(),HttpStatus.OK);
    
}

@GetMapping("/{id}")
public ResponseEntity<Optional<Product>>getSIngleproduct(@PathVariable ObjectId id){

    return new ResponseEntity<>(productservice.Singleproduct(id),HttpStatus.OK);

}

// @PostMapping
// public ResponseEntity<Product> addProduct(@Requestbody Product product){

//     return new ResponseEntity<>(productservice.saveProduct(product), HttpStatus.CREATED);
// }



}
