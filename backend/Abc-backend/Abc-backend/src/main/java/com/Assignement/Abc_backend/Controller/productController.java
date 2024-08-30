package com.Assignement.Abc_backend.Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Assignement.Abc_backend.Model.Product;
import com.Assignement.Abc_backend.Service.ProductService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    ProductService productService;

    private static final String DIRECTORY = "C:\\Users\\Acer\\Abc-Restaurant\\backend\\Abc-backend\\Abc-backend\\src\\main\\resources\\static\\Images\\";

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.allProduct(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>>getSIngleproduct(@PathVariable ObjectId id){
    
        return new ResponseEntity<>(productService.Singleproduct(id),HttpStatus.OK);
    
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestParam("Productname") String productName,
            @RequestParam("Description") String description,
            @RequestParam("Price") int price,
            @RequestParam("Quantity") int quantity,
            @RequestParam("Category") String category,
            @RequestParam("image") MultipartFile file) {

                if (productName == null || productName.isEmpty()
                || description == null || description.isEmpty()
                || price <= 0 || file == null || file.isEmpty()
                || quantity<=0|| file==null ||file.isEmpty()
                || category ==null || category.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
        

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(DIRECTORY + fileName);

        try {
            file.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        String imageUrl = "http://localhost:8080/images/" + fileName;
        Product product = new Product();
        product.setProductname(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setImageurl(imageUrl);
        product.setId(ObjectId.get());
       

        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);

        
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Product> deleteProduct(@PathVariable ObjectId id) {
    productService.deleteproduct(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

    public boolean isValidDetails(String productName, String description, int price, int quantity, String category) {
        if (productName == null || productName.isEmpty()
                || description == null || description.isEmpty()
                || price <= 0 || quantity <= 0 || category == null || category.isEmpty()) {
            return false;
        }
        return true;
    }
    
}
