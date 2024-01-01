INSERT INTO roles (user_roles) VALUES ('USER'), ('ADMIN');

CREATE TABLE user_roles(
    id INTEGER PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
);