CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    full_name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    current_level TEXT NOT NULL,
    address TEXT NOT NULL,
    started DATE NOT NULL,
    unique (name)
);