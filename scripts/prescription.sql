DROP TABLE prescription;
CREATE TABLE "prescription" (
    prescription_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES "users"(user_id),
    dosage VARCHAR(50), -- Dosagem (ex: 1 comprimido, 5 mL)
    frequency VARCHAR(50), -- Frequência (ex: "A cada 8 horas")
    start_date DATE, -- Data de início do tratamento
    end_date DATE, -- Data de término do tratamento
    instructions TEXT -- Instruções adicionais
);