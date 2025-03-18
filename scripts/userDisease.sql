DROP TABLE "user_disease";
CREATE TABLE "user_disease" (
    user_id INT REFERENCES "user"(user_id),
    disease_id INT REFERENCES "disease"(disease_id),
    PRIMARY KEY (user_id, disease_id)
);