package com.Assignment.Abc_Restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.Assignment.Abc_Restaurant.Controller.productController;
import com.Assignment.Abc_Restaurant.Service.ProductService;

public class DeleteProductTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private productController productController;

    @BeforeEach
    public void setup() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteProduct() {
        ObjectId id = new ObjectId();
        when(com.Assignment.Abc_Restaurant.Model.Product.deleteproduct(id)).thenReturn(false); // Mocking the service to return false
    
    }
}
