CREATE TABLE  auth.users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    username VARCHAR(255) NOT NULL
);

INSERT INTO  auth.users (email, password, role, username) VALUES
('admin@example.com', '$2a$10$L0uDKRQ6xh5pev5AJzu9.Oq8hUOzJFNeJwHe.mPb1nvgJ9jALgKQi', 'ADMIN', 'AdminUser');