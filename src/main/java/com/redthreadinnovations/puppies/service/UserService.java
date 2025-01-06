package com.redthreadinnovations.puppies.service;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger( UserService.class );
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	//-------------------------------------------//

    public User save(User user) {
    	
        return userRepository.save(user);
    }

    
    public void deleteById(Long id) {
    	
        userRepository.deleteById(id);
    }
    
    
    public List<User> findAll() {
    	
        return userRepository.findAll();
    }

    
    public Optional<User> findById(Long id) {
    	
        return userRepository.findById(id);
    }

    
    public Optional<User> findByEmailAndPassword( String email, String password ) {
    	
        Optional<User> user = userRepository.findByEmail( email );
        
        if ( user.isPresent() && passwordEncoder.matches( password, user.get().getPassword() ) ) {

            return user;
        }

        return Optional.empty();
    }

}