package com.redthreadinnovations.puppies.dto;
import jakarta.validation.constraints.NotNull;


public class LikeDTO {

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Post ID is mandatory")
    private Long postId;

    
    //-------------------------------------------//

    public LikeDTO(){
    }

    public LikeDTO( Long userId, Long postId ) {

        this.userId = userId;
        this.postId = postId;
    }

    //-------------------------------------------//
    
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