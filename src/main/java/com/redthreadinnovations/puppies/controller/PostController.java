package com.redthreadinnovations.puppies.controller;
import com.redthreadinnovations.puppies.dto.PostDTO;
import com.redthreadinnovations.puppies.entity.Post;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.service.PostService;
import com.redthreadinnovations.puppies.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    //-------------------------------------------//
    
    @PostMapping("/create")
    public ResponseEntity<Post> createPost( @RequestBody PostDTO postDTO ) {
    	
        User author = userService.findById( postDTO.getAuthorId() )
                                 .orElseThrow( () -> new RuntimeException("Author not found") );
        
        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setImageUrl(postDTO.getImageUrl());
        post.setAuthor( author );
        
        Post createdPost = postService.save( post );
        
        return ResponseEntity.ok( createdPost );
    }


    @GetMapping("/getbyid/{postId}")
    public ResponseEntity<Post> getPostById( @PathVariable Long postId ) {
    	
        Optional<Post> post = postService.findById(postId);
        
        if ( post.isPresent() ) {
        	
            return ResponseEntity.ok( post.get() );
            
        } else {
        	
            return ResponseEntity.notFound().build();
        }
    }      


    @GetMapping("/feedbyuser/{userId}")
    public ResponseEntity< List<Post> > getUserFeed( @PathVariable Long userId ) {
    	
        User user = userService.findById(userId)
                               .orElseThrow( () -> new RuntimeException("User not found") );

        List<Post> posts = postService.findByAuthorOrderByCreatedAtDesc(user);
        
        return ResponseEntity.ok(posts);
    }


    @GetMapping("/feed")
    public ResponseEntity< Page<Post> > getFeed( @RequestParam(defaultValue = "0" ) int page,
                                                 @RequestParam(defaultValue = "10") int size ) {
    	
        Pageable pageable = PageRequest.of( page, size );
        
        Page<Post> posts = postService.findAllByOrderByCreatedAtDesc( pageable );
        
        return ResponseEntity.ok( posts );
    }

}