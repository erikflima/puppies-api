-- Inserir usuarios de exemplo
INSERT INTO users (name, email, password)
VALUES
  ('Alice', 'alice@example.com', '$2a$10$VgF7zLlrMv.9Zg5B5Bg5bOV4SE3MDWdJlZ4tPrUnUTcFuJILcWUpO'), -- Senha: password1
  ('Bob', 'bob@example.com', '$2a$10$M1DeUGzVXKqB0hqRS3F7Q.yhHTNGYV4AW.yAjU4u5XWg2.Cgpfn/K'),   -- Senha: password2
  ('Erik', 'erik@example.com', '$2a$10$M1DeUGzVXKqB0hqRS3F7Q.yhHTNGYV4AW.yAjU4u5XWg2.Cgpfn/K');   -- Senha: password2

-- Inserir posts de exemplo
INSERT INTO posts (content, image_url, created_at, author_id)
VALUES
  ('Primeira publicação', 'https://example.com/image1.jpg', CURRENT_TIMESTAMP, 1),
  ('Segunda publicação', 'https://example.com/image2.jpg', CURRENT_TIMESTAMP, 2);

-- Inserir likes de exemplo
INSERT INTO likes (user_id, post_id, liked_at)
VALUES
  (1, 2, CURRENT_TIMESTAMP),  -- Bob curte a publicação de Alice
  (2, 1, CURRENT_TIMESTAMP);  -- Alice curte a publicação de Bob