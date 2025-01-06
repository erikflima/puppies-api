package com.redthreadinnovations.puppies.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "liked_at", nullable = false, updatable = false)
    private LocalDateTime likedAt = LocalDateTime.now();

	//-------------------------------------------//
      
	public Like() {
	}

	public Like(Long id, User user, Post post, LocalDateTime likedAt) {

		this.id = id;
		this.user = user;
		this.post = post;
		this.likedAt = likedAt;
	}

	//-------------------------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public LocalDateTime getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}

}