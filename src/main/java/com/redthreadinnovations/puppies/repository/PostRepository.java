package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}