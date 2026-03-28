
CREATE TABLE IF NOT EXISTS product
(
    id            INTEGER          NOT NULL,
    name          VARCHAR(255),
    description   VARCHAR(255),
    available_qty DOUBLE PRECISION NOT NULL,
    price         DECIMAL(32,2),
    category_id   INTEGER CONSTRAINT product_category_id REFERENCES category,
    CONSTRAINT pk_product PRIMARY KEY (id)
);
CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 50;


