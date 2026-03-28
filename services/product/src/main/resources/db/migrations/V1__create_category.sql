
CREATE TABLE IF NOT EXISTS category
(
    id          INTEGER NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_category PRIMARY KEY (id)
);
CREATE SEQUENCE IF NOT EXISTS category_seq START WITH 1 INCREMENT BY 50;
