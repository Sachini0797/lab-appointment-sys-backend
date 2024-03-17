package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.User;
import com.sachini.labappointmentsys.repository.UserRepository;
import com.sachini.labappointmentsys.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class userController {

    private final Logger log = LoggerFactory.getLogger(userController.class);
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user-profiles")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        // Logic to retrieve all users from the database
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.debug("REST request to get UserProfile : {}", id);
        // Find the user by ID in the repository
        User user = userRepository.findById(id)
                .orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK); // Return user if found

    }
}
