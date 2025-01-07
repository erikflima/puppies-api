package com.redthreadinnovations.puppies.controller;
import com.redthreadinnovations.puppies.dto.UserDTO;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


/**
 * Controller for managing user-related operations.
 * Provides endpoints for creating users and retrieving user profiles.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //-------------------------------------------//
    

    /**
     * Creates a new user.
     *
     * @param userDTO the data transfer object containing user details
     * @return the created user
     */
    @PostMapping("/create") 
    public ResponseEntity<User> createUser( @Validated @RequestBody UserDTO userDTO ) {
    	
        User user = new User();
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( passwordEncoder.encode( userDTO.getPassword() ) );
        
        User createdUser = userService.save(user);
        
        return ResponseEntity.ok(createdUser);
    }

    
    /**
     * Retrieves a user profile by its ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the user with the specified ID, or 404 if not found
     */
    @GetMapping("/getbyid/{userId}")
    public ResponseEntity<User> getUserProfileById( @PathVariable Long userId ) {
    	
        Optional<User> user = userService.findById( userId );
        
        if ( user.isPresent() ) {
        
        	return ResponseEntity.ok( user.get() );
        
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}