DROP TABLE IF EXISTS prescription_notification;
CREATE TABLE prescription_notification (
    notification_id SERIAL PRIMARY KEY,
    prescription_id INT NOT NULL REFERENCES prescription(prescription_id) ON DELETE CASCADE,
    notification_time TIMESTAMP NOT NULL,
    status VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);