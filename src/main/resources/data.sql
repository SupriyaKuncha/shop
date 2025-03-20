


INSERT INTO authors (name, country) VALUES ('J.K. Rowling', 'India'), ('Robert', 'US');

INSERT INTO books (title, author_id, price) VALUES
                  ('Spring Framework', 1, 350.00),
                  ('Microservices', 2, 450.00);

INSERT INTO orders (bookId, quantity) VALUES
                   (1, 2),
                   (2, 2);