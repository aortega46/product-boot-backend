INSERT INTO category (name) VALUES ('Electrónicos'), ('Ropa'), ('Hogar');

INSERT INTO product (name, price, description, thumbnail) VALUES ( 'Smartphone', 599.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Televisor', 799.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Laptop', 1299.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Camiseta', 19.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Pantalones', 29.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Mesa de centro', 149.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Lámpara de pie', 79.99, "Generic description", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");

INSERT INTO category_products (categories_id, products_id) VALUES (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7);  


INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/1/1.jpg', 1);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/1/2.jpg', 1);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/1/3.jpg', 1);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/2/1.jpg', 2);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/2/2.jpg', 2);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/2/3.jpg', 2);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/3/1.jpg', 3);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/3/2.jpg', 3);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/3/3.jpg', 3);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/4/1.jpg', 4);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/4/2.jpg', 4);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/4/3.jpg', 4);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/5/1.jpg', 5);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/5/2.jpg', 5);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/5/3.jpg', 5);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/6/1.jpg', 6);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/6/2.jpg', 6);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/6/3.jpg', 6);

INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/7/1.jpg', 7);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/7/2.jpg', 7);
INSERT INTO image (id, url, product_id) VALUES (UUID(), 'https://cdn.dummyjson.com/product-images/7/3.jpg', 7);
