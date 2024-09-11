package com.Assignment.Abc_Restaurant.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.Abc_Restaurant.Model.Product;
import com.Assignment.Abc_Restaurant.Repository.productRepository;
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

public Product getProductById(ObjectId id) {
    
    Optional<Product> product = Singleproduct(id);
       
        return product.orElse(null);
} 

public List<Product> getProductById (String category){

    if (category.equalsIgnoreCase("all")) {
        return Productrepository.findAll(); 
    } else {
        
        return Productrepository.findByCategory(category); 

    }
}
}


