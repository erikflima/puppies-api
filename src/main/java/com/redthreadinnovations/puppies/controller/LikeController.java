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
    
    @PostMapping("/likeapost")
    public ResponseEntity<Like> likeAPost( @RequestBody LikeDTO likeDTO ) {
    	
        User user = userService.findById(likeDTO.getUserId())
                               .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postService.findById(likeDTO.getPostId())
                               .orElseThrow(() -> new RuntimeException("Post not found"));

        // Verifica se o usuario ja curtiu a publicacao.
        Optional<Like> existingLike = likeService.findByUserAndPost( user, post );
        
        if ( existingLike.isPresent() ) {
        	
        	// Se a curtida ja existir, retorna a curtida existente.
            return ResponseEntity.ok( existingLike.get() );
        }

        // Cria uma nova curtida se nao existir uma anterior.
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        Like createdLike = likeService.save( like );
        
        return ResponseEntity.ok( createdLike );
    }


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

