CREATE TABLE tb_address (
    id BIGSERIAL PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    event_id BIGINT,
    FOREIGN KEY (event_id) REFERENCES tb_event(id) ON DELETE SET NULL
);
