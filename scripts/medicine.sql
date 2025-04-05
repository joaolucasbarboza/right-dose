DROP TABLE IF EXISTS medicine;
CREATE TABLE medicine (
    medicine_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users(user_id),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    quantity INT NOT NULL,
    unit VARCHAR(50) NOT NULL,
    dosage_amount DOUBLE PRECISION NOT NULL,
    dosage_unit VARCHAR(50) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);