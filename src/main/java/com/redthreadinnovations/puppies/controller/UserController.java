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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger( UserController.class );   
    
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //-------------------------------------------//
    

    @PostMapping("/create") 
    public ResponseEntity<User> createUser( @Validated @RequestBody UserDTO userDTO ) {
    	
        User user = new User();
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( passwordEncoder.encode( userDTO.getPassword() ) );
        
        User createdUser = userService.save(user);
        
        return ResponseEntity.ok(createdUser);
    }


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