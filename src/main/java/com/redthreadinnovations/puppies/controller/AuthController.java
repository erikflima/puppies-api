package com.redthreadinnovations.puppies.controller;
import com.redthreadinnovations.puppies.dto.LoginDTO;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


/**
* Controller for handling authentication-related operations.
* Provides endpoints for user login.
*/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    /**
     * Authenticates a user based on provided login credentials.
     *
     * @param loginDTO the data transfer object containing login details
     * @return a response entity with a success message if credentials are valid, or an error message if invalid
     */    
    @PostMapping("/login")
    public ResponseEntity<String> login( @RequestBody LoginDTO loginDTO ) {
    	
        Optional<User> user = userService.findByEmailAndPassword( loginDTO.getEmail(), loginDTO.getPassword() );

        if ( user.isPresent() ) {
        	
            return ResponseEntity.ok("Login successful");
            
        } else {
        	
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}