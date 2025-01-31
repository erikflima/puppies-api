package com.redthreadinnovations.puppies.service;
import com.redthreadinnovations.puppies.entity.Post;
import com.redthreadinnovations.puppies.entity.User;
import com.redthreadinnovations.puppies.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //-------------------------------------------//
    
    public List<Post> findAll() {

    	return postRepository.findAll();
    }

    
    public Optional<Post> findById(Long id) {

    	return postRepository.findById(id);
    }

    
    public Post save(Post post) {

    	return postRepository.save(post);
    }

    
    public void deleteById(Long id) {

    	postRepository.deleteById(id);
    }

    
    public List<Post> findByAuthorOrderByCreatedAtDesc( User author ) {
    	
        return postRepository.findByAuthorOrderByCreatedAtDesc(author);
    }


    public Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable) {
    	
        return postRepository.findAllByOrderByCreatedAtDesc( pageable );
    }

}