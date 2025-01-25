CREATE TABLE donors (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE donations (
    id INT PRIMARY KEY,
    amount DECIMAL(10, 2),
    donor_id INT REFERENCES donors(id)
);

CREATE TABLE charities (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT
);
