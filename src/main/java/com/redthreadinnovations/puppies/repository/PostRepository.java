package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.Post;
import com.redthreadinnovations.puppies.entity.User;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByAuthorOrderByCreatedAtDesc( User author );

	Page<Post> findAllByOrderByCreatedAtDesc( Pageable pageable );

}