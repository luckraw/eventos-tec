CREATE TABLE tb_coupon (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    discount INTEGER NOT NULL,
    valid TIMESTAMP NOT NULL,
    event_id BIGINT,
    FOREIGN KEY (event_id) REFERENCES tb_event(id) ON DELETE SET NULL
);
