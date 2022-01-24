CREATE TABLE city
(
    id      INT PRIMARY KEY auto_increment,
    name    VARCHAR,
    state   VARCHAR,
    country VARCHAR,
    CONSTRAINT u_city_name UNIQUE (name)
);