INSERT INTO category (id, name) VALUES (1, 'Electrónicos'), (2, 'Ropa'), (3, 'Hogar');

INSERT INTO product (id, name, price) VALUES (1, 'Smartphone', 599.99), (2, 'Televisor', 799.99), (3, 'Laptop', 1299.99), (4, 'Camiseta', 19.99), (5, 'Pantalones', 29.99), (6, 'Mesa de centro', 149.99), (7, 'Lámpara de pie', 79.99);

INSERT INTO category_products (categories_id, products_id) VALUES (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7);  
