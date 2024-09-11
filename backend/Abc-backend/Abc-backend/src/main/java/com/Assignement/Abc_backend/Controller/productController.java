package com.Assignment.Abc_Restaurant.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Assignment.Abc_Restaurant.Model.Product;
import com.Assignment.Abc_Restaurant.Service.ProductService;



@Controller
@RequestMapping
public class productController {

    @Autowired
    ProductService productService;

    private static final String DIRECTORY = "D:\\Abc_Restaurant\\src\\main\\resources\\static\\images";

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.allProduct(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>>getSIngleproduct(@PathVariable ObjectId id){
    
        return new ResponseEntity<>(productService.Singleproduct(id),HttpStatus.OK);
    
    }

    @PostMapping("/new-product")
    public ResponseEntity<Product> addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("Description") String description,
            @RequestParam("Price") int price,
            @RequestParam("Quantity") int quantity,
            @RequestParam("Category") String category,
            @RequestParam("image") MultipartFile file) {

                if (productName == null || productName.isEmpty()
                || description == null || description.isEmpty()
                || price <= 0 || file == null || file.isEmpty()
                || quantity<=0
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
    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") ObjectId id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        String fileName = product.getImageurl().substring(product.getImageurl().lastIndexOf('/') + 1);
        Path filePath = Paths.get(DIRECTORY, fileName);

        try {
            byte[] imageBytes = Files.readAllBytes(filePath);
            String mimeType = Files.probeContentType(filePath);
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .body(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){

        List<Product> products=productService.getProductById(category);
        return new ResponseEntity<>(products, HttpStatus.OK);


    }
    

    @GetMapping("/manage-product")
    public String getProductpage(Model model){

         model.addAttribute("product", new Product());


        return "Product";
    }

    @GetMapping("/add-product")
    public String addproduct(Model model){

        model.addAttribute("product", new Product());

        return "Add Product";
    }
}
