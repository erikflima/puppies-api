package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findByEmail( String email );

}