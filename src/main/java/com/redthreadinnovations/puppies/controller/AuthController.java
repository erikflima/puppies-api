package com.redthreadinnovations.puppies.controller;
import com.redthreadinnovations.puppies.dto.LoginDTO;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

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