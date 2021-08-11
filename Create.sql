CREATE TABLE IF NOT EXISTS products
(
    id    BIGINT GENERATED ALWAYS AS IDENTITY (START 1000 INCREMENT 1) NOT NULL,
    title VARCHAR(255),
    cost  DECIMAL(12, 2),
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customers
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY (START 100 INCREMENT 1) NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    customer_id BIGINT NOT NULL,
    date        TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

CREATE TABLE IF NOT EXISTS ordered_products
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity   INTEGER,
    cost       DECIMAL(12, 2),
    CONSTRAINT pk_ordered_products PRIMARY KEY (id)
);

ALTER TABLE ordered_products
    ADD CONSTRAINT FK_ORDERED_PRODUCTS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE ordered_products
    ADD CONSTRAINT FK_ORDERED_PRODUCTS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

INSERT INTO customers (name) VALUES ('Иван Иванов'),
                                    ('Петр Петров'),
                                    ('Дмитрий Дмитриев'),
                                    ('Николай Николаев');
INSERT INTO products (title, cost) VALUES ('Мука', 1.50),
                                          ('Яйца', 5.63),
                                          ('Масло', 3.45),
                                          ('Молоко', 2.32),
                                          ('Вода', 0.25);
INSERT INTO orders (customer_id, date) VALUES (100, '2020-07-12 12:23'),
                                              (100, '2020-07-14 15:18'),
                                              (100, '2020-07-16 10:12'),
                                              (101, '2020-07-12 14:10'),
                                              (101, '2020-07-18 21:03'),
                                              (101, '2020-07-13 20:57'),
                                              (102, '2020-07-15 18:09'),
                                              (102, '2020-07-16 10:11'),
                                              (102, '2020-07-17 12:13'),
                                              (102, '2020-07-10 10:00'),
                                              (102, '2020-07-11 11:00'),
                                              (101, '2020-07-10 17:00');
INSERT INTO ordered_products (order_id, product_id, quantity, cost) VALUES (1, 1000, 10, 2.35),
                                                                           (1, 1001, 5, 1.50),
                                                                           (1, 1002, 20, 3.25),
                                                                           (2, 1002, 5, 1.12),
                                                                           (2, 1003, 4, 1.15),
                                                                           (2, 1004, 3, 1.18),
                                                                           (3, 1000, 2, 0.15),
                                                                           (3, 1002, 3, 0.19),
                                                                           (3, 1001, 6, 0.25),
                                                                           (4, 1002, 1, 2.00),
                                                                           (5, 1003, 1, 2.00),
                                                                           (6, 1004, 1, 2.00),
                                                                           (7, 1001, 2, 4.00),
                                                                           (8, 1001, 3, 3.00),
                                                                           (9, 1003, 4, 2.00),
                                                                           (10, 1002, 5, 1.52),
                                                                           (10, 1003, 4, 8.85),
                                                                           (11, 1004, 3, 8.63),
                                                                           (12, 1004, 5, 5.12),
                                                                           (12, 1000, 4, 3.15),
                                                                           (12, 1002, 3, 2.18);