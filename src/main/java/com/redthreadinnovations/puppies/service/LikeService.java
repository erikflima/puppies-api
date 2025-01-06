package com.redthreadinnovations.puppies.service;
import com.redthreadinnovations.puppies.entity.Like; 
import com.redthreadinnovations.puppies.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.List; 
import java.util.Optional;


@Service 
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;


	public List<Like> findAll() {
		
	    return likeRepository.findAll();
	}
	
	public Optional<Like> findById(Long id) {
		
	    return likeRepository.findById(id);
	}
	
	public Like save(Like like) {
		
	    return likeRepository.save(like);
	}
	
	public void deleteById(Long id) {
		
	    likeRepository.deleteById(id);
	}

}