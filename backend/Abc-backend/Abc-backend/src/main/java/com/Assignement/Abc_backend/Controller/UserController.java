package com.Assignement.Abc_backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Assignement.Abc_backend.Model.User;
import com.Assignement.Abc_backend.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class UserController {


    private UserRepository userepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity registeruser(@RequestBody User user){

       
            if(userepository.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already taken");

           
            }


        
            String role=user.getRole();

            if(role==null || role.isEmpty()){
                user.setRole("Customer");
            } else if(role.equals("Admin")){

                boolean adminExists = userepository.findByRole("Admin").isPresent();
                if (adminExists) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin already exists.");
                }
            } else if (!role.equals("Admin") && !role.equals("Customer")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role provided");
            }
        

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            User save= userepository.save(user);
        

        


            return ResponseEntity.status(HttpStatus.CREATED)
            .body("User registered successfully with role: " + user.getRole());



            
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        return ResponseEntity.ok("Login successful");
    }

}

