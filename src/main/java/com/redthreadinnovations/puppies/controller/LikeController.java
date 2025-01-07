package com.redthreadinnovations.puppies.controller;
import com.redthreadinnovations.puppies.dto.LikeDTO;
import com.redthreadinnovations.puppies.entity.Like;
import com.redthreadinnovations.puppies.entity.Post;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.service.LikeService;
import com.redthreadinnovations.puppies.service.PostService;
import com.redthreadinnovations.puppies.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing like-related operations.
 * Provides endpoints for liking posts and retrieving liked posts by user.
 */
@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    //-------------------------------------------//
    
    
    /**
    * Likes a post.
    *
    * @param likeDTO the data transfer object containing like details
    * @return the created like or the existing like if already liked
    */    
    @PostMapping("/likeapost")
    public ResponseEntity<Like> likeAPost( @RequestBody LikeDTO likeDTO ) {
    	
        User user = userService.findById(likeDTO.getUserId())
                               .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postService.findById(likeDTO.getPostId())
                               .orElseThrow(() -> new RuntimeException("Post not found"));

        // Checks if the user has already liked the post.
        Optional<Like> existingLike = likeService.findByUserAndPost( user, post );
        
        if ( existingLike.isPresent() ) {
        	
        	// If the like already exists, returns the existing like.
            return ResponseEntity.ok( existingLike.get() );
        }

        // Creates a new like if there is no previous one.
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        Like createdLike = likeService.save( like );
        
        return ResponseEntity.ok( createdLike );
    }


    /**
     * Retrieves the posts liked by a specific user.
     *
     * @param userId the ID of the user whose liked posts to retrieve
     * @return the list of posts liked by the specified user
     */
    @GetMapping("/likedpostsbyuser/{userId}")
    public ResponseEntity< List<Post> > getLikedPostsByUserId( @PathVariable Long userId ) {

        User user = userService.findById( userId )
                               .orElseThrow( () -> new RuntimeException("User not found") );

        List<Like> likes = likeService.findByUser( user );
        
        List<Post> likedPosts = likes.stream()
                                     .map(Like::getPost)
                                     .collect( Collectors.toList() );

        return ResponseEntity.ok( likedPosts );
    }  
    
}