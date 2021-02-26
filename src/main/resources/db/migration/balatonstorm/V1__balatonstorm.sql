CREATE TABLE if NOT EXISTS balatonstorm(
    id INT,
    station VARCHAR(32),
    lat DOUBLE,
    lng DOUBLE,
    description VARCHAR(255),
    level INT,
    group_id VARCHAR(4),
    station_type VARCHAR(4)
);