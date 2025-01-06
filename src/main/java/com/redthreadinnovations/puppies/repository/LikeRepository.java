package com.redthreadinnovations.puppies.repository;
import com.redthreadinnovations.puppies.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}