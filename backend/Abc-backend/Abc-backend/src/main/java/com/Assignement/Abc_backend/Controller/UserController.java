package com.Assignment.Abc_Restaurant.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Assignment.Abc_Restaurant.Model.User;
import com.Assignment.Abc_Restaurant.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Controller
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

    @GetMapping("/manage-users")
    public String manageUser(Model model) {
        List<User> users = userepository.findAll();
      
        model.addAttribute("users", users);
        return "ManageUser"; 
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
        } else if ("Admin".equals(role)) {
            if (userepository.findByRole("Admin").isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin already exists.");
            }
        } else {
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

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        if (!userepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody User userDetails) {
        return userepository.findById(id)
            .map(user -> {
                user.setUsername(userDetails.getUsername());
                if (!user.getPassword().equals(userDetails.getPassword())) {
                    user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                }
                user.setRole(userDetails.getRole()); // Ensure proper role validation here
                User updatedUser = userepository.save(user);
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            })
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

    
