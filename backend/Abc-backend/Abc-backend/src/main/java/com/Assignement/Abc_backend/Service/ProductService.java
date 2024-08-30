package com.Assignement.Abc_backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignement.Abc_backend.Model.Product;
import com.Assignement.Abc_backend.Repository.productRepository;
@Service
public class ProductService {

@Autowired
private productRepository Productrepository;

public List<Product> allProduct(){
    return Productrepository.findAll();

}

public Optional<Product> Singleproduct(ObjectId id){

    return Productrepository.findById(id);

}

public Product addProduct (Product product){

    return Productrepository.save(product);
}

public boolean deleteproduct(ObjectId id){

    if(Productrepository.existsById(id)){

        Productrepository.deleteById(id);

        return true;

    }
    else return false;

} 
}


