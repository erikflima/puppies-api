package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.Like;
import com.redthreadinnovations.puppies.entity.Post;
import com.redthreadinnovations.puppies.entity.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, Long> {

	Optional<Like> findByUserAndPost(User user, Post post);

	List<Like> findByUser( User user );

}