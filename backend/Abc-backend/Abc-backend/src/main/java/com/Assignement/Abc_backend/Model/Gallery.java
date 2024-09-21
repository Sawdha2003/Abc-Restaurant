package com.Assignment.Abc_Restaurant.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Gallery")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Gallery {
    
    @Id
    private ObjectId id;
    private String imageurl;
    private String description;

    public String getId() {
        return this.id != null ? this.id.toHexString() : null; 
    }
    


}
