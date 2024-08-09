CREATE TABLE tb_event (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    img_url VARCHAR(255),
    event_url VARCHAR(255),
    remote BOOLEAN,
    date TIMESTAMP NOT NULL
);
