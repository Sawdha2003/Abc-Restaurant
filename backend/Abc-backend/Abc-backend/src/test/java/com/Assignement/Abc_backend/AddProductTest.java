package com.Assignement.Abc_backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Assignement.Abc_backend.Controller.productController;

public class AddProductTest {

    private productController productcontroller;

    @BeforeEach
    public void setup() {
        productcontroller = new productController();
    }

    @Test
    public void Testproductdetails(){

        assertTrue(productcontroller.isValidDetails("product", "incredible", 1000, 5, "Food"));
        assertFalse(productcontroller.isValidDetails("Product","",500,5,""));
        assertFalse(productcontroller.isValidDetails("", "incredible product", 1000, 5, "Food"));
    
    }
    
}