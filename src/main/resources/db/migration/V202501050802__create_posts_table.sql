CREATE TABLE posts (
	
    id SERIAL  PRIMARY KEY,
    content    VARCHAR(255) NOT NULL,
    image_url  VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author_id  INT 		    NOT NULL,

    FOREIGN KEY (author_id) REFERENCES users (id)

);