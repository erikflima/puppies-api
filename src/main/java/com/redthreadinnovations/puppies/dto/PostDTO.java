package com.redthreadinnovations.puppies.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class PostDTO {

    @NotBlank(message = "Content is mandatory")
    private String content;

    private String imageUrl;

    @NotNull(message = "Author ID is mandatory")
    private Long authorId;

	//-------------------------------------------//
    
    public PostDTO() {
	}

	public PostDTO( String content, String imageUrl, Long authorId ) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.authorId = authorId;
	}

	//-------------------------------------------//

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}