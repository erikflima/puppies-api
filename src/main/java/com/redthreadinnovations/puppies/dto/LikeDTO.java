package com.redthreadinnovations.puppies.dto;
import jakarta.validation.constraints.NotNull;


/**
 * Data Transfer Object for Like entity. Used to transfer like data between
 * processes.
 */
public class LikeDTO {

	@NotNull(message = "User ID is mandatory")
	private Long userId;

	@NotNull(message = "Post ID is mandatory")
	private Long postId;

	// -------------------------------------------//

	public LikeDTO() {
	}

	/**
	 * Parameterized constructor.
	 *
	 * @param userId the ID of the user who liked the post
	 * @param postId the ID of the post that was liked
	 */
	public LikeDTO(Long userId, Long postId) {

		this.userId = userId;
		this.postId = postId;
	}

	// -------------------------------------------//

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}