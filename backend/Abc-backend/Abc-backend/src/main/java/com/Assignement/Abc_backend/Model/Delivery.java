package com.Assignment.Abc_Restaurant.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Delivery {

    @Id
    private ObjectId id;
    private String address;
    private String productname;
    private String note;
    private int quantity;
}
