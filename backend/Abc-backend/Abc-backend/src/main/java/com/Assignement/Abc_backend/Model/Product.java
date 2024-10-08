package com.Assignment.Abc_Restaurant.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    private ObjectId id;
    private String Productname;
    private String Description;
    private int Price;
    private int Quantity;
    private String Category;
    private String imageurl;
    public static Object deleteproduct(ObjectId id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteproduct'");
    }

}
