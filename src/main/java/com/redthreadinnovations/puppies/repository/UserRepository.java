package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}