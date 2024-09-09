package com.Assignment.Abc_Restaurant.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String username;
    private String password;
    private String email;
    private String role;
    
	public String getRole() {
		
		return this.role; 
	}
	public String getPassword() {
		
		return this.password; 
	}
    public Object setId(String hexString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public String getId() {
        return this.id.toHexString();
    }
    
}
