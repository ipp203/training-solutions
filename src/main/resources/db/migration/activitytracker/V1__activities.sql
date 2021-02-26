CREATE TABLE if NOT EXISTS activities (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    start_time DATETIME,
    activity_desc VARCHAR(255),
    activity_type VARCHAR(16)
);

CREATE TABLE if NOT EXISTS track_point (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    track_time TIMESTAMP,
    lat DOUBLE,
    lon DOUBLE,
    activity_id INT(10),
    CONSTRAINT fk_activity FOREIGN KEY (activity_id) REFERENCES activities(id)
);