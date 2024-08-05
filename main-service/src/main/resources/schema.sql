DROP TABLE IF EXISTS users, categories, events, locations CASCADE;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    member_name VARCHAR(250) NOT NULL,
    email VARCHAR(254) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS categories (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS locations (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    lat FLOAT,
    lon FLOAT
);

CREATE TABLE IF NOT EXISTS events (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    create_date TIMESTAMP,
    event_date TIMESTAMP,
    title VARCHAR(120),
    annotation VARCHAR(2000),
    description VARCHAR(7000),
    state VARCHAR,
    category_id INTEGER,
    user_id INTEGER,
    confirmed_requests INTEGER,
    participant_limit INTEGER,
    views_count INTEGER,
    paid BOOLEAN,
    request_moderation BOOLEAN,
    location_id INTEGER,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(category_id) REFERENCES categories(id),
    FOREIGN KEY(location_id) REFERENCES locations(id)
);