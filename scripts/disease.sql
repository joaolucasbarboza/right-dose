DROP TABLE "disease";
CREATE TABLE "disease" (
    disease_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);