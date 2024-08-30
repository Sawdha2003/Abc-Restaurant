package com.Assignement.Abc_backend.Model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Dine-in")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dinein {


    @Id
    private ObjectId id;
    private LocalDate date;
    private int  guests;
    private String Name;
    private String number;
    private String email;
    private String Status;
    
}
