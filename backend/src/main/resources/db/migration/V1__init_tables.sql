CREATE TABLE users(
    id serial NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE roles(
    id serial NOT NULL PRIMARY KEY,
    user_roles VARCHAR NOT NULL
);

CREATE TABLE services(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(50),
    cost_our NUMERIC(18, 2),
    cost_foreign NUMERIC(18, 2)
);

CREATE TABLE cars(
    id INTEGER PRIMARY KEY NOT NULL,
    num VARCHAR(20),
    color VARCHAR(20),
    mark VARCHAR(20),
    is_foreign INTEGER
);

CREATE TABLE masters(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE works(
    id INTEGER PRIMARY KEY NOT NULL,
    date_work DATE,
    master_id INTEGER,
    car_id INTEGER,
    service_id INTEGER,
    FOREIGN KEY (master_id) REFERENCES masters(id) ON DELETE CASCADE,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES services(id) ON DELETE CASCADE
);

