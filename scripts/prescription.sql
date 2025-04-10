DROP TABLE IF EXISTS prescription;
CREATE TABLE "prescription" (
    prescription_id SERIAL PRIMARY KEY,
    medicine_id INT NOT NULL REFERENCES medicine(medicine_id) ON DELETE CASCADE,
    user_id int NOT NULL REFERENCES users(user_id),
    dosage_amount DOUBLE PRECISION, -- Quantidade da Dosagem (ex: 1 | 5 )
    dosage_unit VARCHAR(20) NOT NULL, -- Unidade da dosagem (ex: comprimido | ml)
    frequency INT, -- Frequência (ex: "A cada 8 | 1")
    uom_frequency VARCHAR(10) NOT NULL, -- UOM Frequency (ex: "Horas | Dias")
    dosage_time TIME,
    total_days INT NOT NULL,
    start_date DATE,
    end_date DATE,
    instructions TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);