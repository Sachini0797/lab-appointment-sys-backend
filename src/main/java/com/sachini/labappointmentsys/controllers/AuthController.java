package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.enums.ERoles;
import com.sachini.labappointmentsys.models.Role;
import com.sachini.labappointmentsys.models.User;
import com.sachini.labappointmentsys.payload.request.LoginRequest;
import com.sachini.labappointmentsys.payload.request.SignupRequest;
import com.sachini.labappointmentsys.payload.request.UserUpdateRequest;
import com.sachini.labappointmentsys.payload.response.JwtResponse;
import com.sachini.labappointmentsys.payload.response.MessageResponse;
import com.sachini.labappointmentsys.repository.RoleRepository;
import com.sachini.labappointmentsys.repository.UserRepository;
import com.sachini.labappointmentsys.security.jwt.JwtUtils;
import com.sachini.labappointmentsys.security.services.EmailService;
import com.sachini.labappointmentsys.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private EmailService emailService;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password. Please check again");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: email is already in use!");
        }

        User user = new User(signUpRequest.getUsername(), signUpRequest.getDesignation(), signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getGender(), signUpRequest.getNic(), signUpRequest.getEmail(), signUpRequest.getPhoneNum(), signUpRequest.getAddress(), signUpRequest.getCity(), signUpRequest.getAge(), signUpRequest.getDob(), signUpRequest.getMaritalStatus(), signUpRequest.getRegisteredDate(), signUpRequest.getHeight(), signUpRequest.getWeight(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERoles.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERoles.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;

                    case "mod":
                        Role modRole = roleRepository.findByName(ERoles.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERoles.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

                        roles.add(userRole);


                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        emailService.sendRegistrationEmail(signUpRequest.getEmail(), user.getId(), user.getUsername());


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logOutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        // Retrieve the user from the database
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();

        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setDesignation(userUpdateRequest.getDesignation());
        user.setGender(userUpdateRequest.getGender());
        user.setNic(userUpdateRequest.getNic());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPhoneNum());
        user.setAddress(userUpdateRequest.getAddress());
        user.setCity(userUpdateRequest.getCity());
        user.setAge(userUpdateRequest.getAge());
        user.setDob(userUpdateRequest.getDob());
        user.setMaritalStatus(userUpdateRequest.getMaritalStatus());
        user.setRegisteredDate(userUpdateRequest.getRegisteredDate());
        user.setHeight(userUpdateRequest.getHeight());
        user.setWeight(userUpdateRequest.getWeight());


        // Apply updates to other fields as needed

        userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }

}
