CREATE TABLE "user_dietary_restriction" (
    user_id INT REFERENCES "users"(user_id),
    restriction_id INT REFERENCES "dietary_restriction"(restriction_id),
    PRIMARY KEY (user_id, restriction_id)
);