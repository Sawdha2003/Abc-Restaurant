package com.Assignement.Abc_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Assignement.Abc_backend.Model.User;
import com.Assignement.Abc_backend.Repository.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserRepository userepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; 
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        log.info("Register endpoint hit");

        if (userepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken");
        }

        String role = user.getRole();

        if (role == null || role.isEmpty()) {
            user.setRole("Customer");
        } else if (role.equals("Admin")) {
            boolean adminExists = userepository.findByRole("Admin").isPresent();
            if (adminExists) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin already exists.");
            }
        } else if (!role.equals("Admin") && !role.equals("Customer")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role provided.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
    
    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userepository.findAll();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/dashboard")
    public String showCustomerDashboard() {
        return "dashboard";  
    }

    @GetMapping("/AdminDashboard")
    public String showAdminDashboard() {
        return "AdminDashboard";  
    }
}
