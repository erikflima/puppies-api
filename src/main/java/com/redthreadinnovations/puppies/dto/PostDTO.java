package com.redthreadinnovations.puppies.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * Data Transfer Object for Post entity.
 * Used to transfer post data between processes.
 */
public class PostDTO {

    @NotBlank(message = "Content is mandatory")
    private String content;

    private String imageUrl;

    @NotNull(message = "Author ID is mandatory")
    private Long authorId;

    //-------------------------------------------//

	public PostDTO() {
	}
	
	/**
	 * Parameterized constructor.
	 *
	 * @param content the content of the post
	 * @param imageUrl the URL of the image associated with the post
	 * @param authorId the ID of the author of the post
	 */
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