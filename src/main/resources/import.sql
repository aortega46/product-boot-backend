INSERT INTO category (name) VALUES ('Electrónicos'), ('Ropa'), ('Hogar');

INSERT INTO product (name, price, description, thumbnail) VALUES ( 'Smartphone', 599.99, "Eu quis proident excepteur laboris ut ipsum dolor labore qui dolore nisi. Lorem sit non cupidatat esse do anim ipsum pariatur.", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Televisor', 799.99, "Veniam ea incididunt cillum nisi velit sunt proident do. Aute nisi ad labore ad laboris adipisicing in occaecat cupidatat est aliqua sunt.", "https://cdn.dummyjson.com/product-images/2/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Laptop', 1299.99, "Consequat aute aliquip quis commodo veniam mollit velit. Nulla sit do esse est veniam incididunt ea aliquip elit.", "https://cdn.dummyjson.com/product-images/3/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Camiseta', 19.99, "Voluptate ex consequat eu dolore ex esse tempor eiusmod reprehenderit tempor fugiat sint veniam eiusmod. Qui ullamco ex id consequat anim quis non qui minim eu quis dolor ex.", "https://cdn.dummyjson.com/product-images/4/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Pantalones', 29.99, "Voluptate voluptate veniam dolore mollit ullamco dolor officia dolore aliqua reprehenderit quis reprehenderit laboris. Pariatur minim sint consequat ipsum excepteur id aute laboris incididunt exercitation laboris ipsum esse.", "https://cdn.dummyjson.com/product-images/5/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Mesa de centro', 149.99, "Exercitation officia non quis sunt sint. Deserunt duis cillum ea deserunt commodo voluptate aliqua et sint sunt fugiat tempor non.", "https://cdn.dummyjson.com/product-images/6/thumbnail.jpg");
INSERT INTO product (name, price, description, thumbnail) VALUES ('Lámpara de pie', 79.99, "Anim dolor eiusmod ex tempor elit tempor et. Eu consectetur deserunt in ex ullamco consequat dolor elit dolor.", "https://cdn.dummyjson.com/product-images/7/thumbnail.jpg");

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
