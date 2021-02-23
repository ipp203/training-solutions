CREATE TABLE if NOT EXISTS activities (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    start_time DATETIME,
    activity_desc VARCHAR(255),
    activity_type VARCHAR(16)
);