CREATE TABLE opportunities.client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(50)
);

CREATE TABLE opportunities.product_interest (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    version VARCHAR(255),
    year_model INT
);
INSERT INTO opportunities.client (name, email, phone) VALUES
('Alice Smith', 'alice@example.com', '123-456-7890'),
('Bob Johnson', 'bob@example.com', '987-654-3210');

INSERT INTO opportunities.product_interest (brand, model, version, year_model) VALUES
('Toyota', 'Corolla', 'XLE', 2020),
('Honda', 'Civic', 'Sport', 2019);