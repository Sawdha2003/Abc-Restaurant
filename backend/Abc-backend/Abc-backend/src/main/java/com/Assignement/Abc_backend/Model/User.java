package com.Assignement.Abc_backend.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import  org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "Users") 

public class User {

    @Id
    private ObjectId id;

    private String Username;

    private String Password;

    private String Email;

    private String role;

}
