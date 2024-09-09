package com.Assignment.Abc_Restaurant.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Document(collection="Query")
public class Contact {

@Id

private ObjectId id;
private String name;
private String email;
private String message;
}
