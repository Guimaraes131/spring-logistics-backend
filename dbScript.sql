CREATE TABLE tb_address(
    id UUID NOT NULL PRIMARY KEY,
    street VARCHAR(64) NOT NULL,
    number VARCHAR(12) NOT NULL,
    complement VARCHAR(128),
    neighbourhood VARCHAR(64) NOT NULL,
    city VARCHAR(64) NOT NULL,
    state VARCHAR(64) NOT NULL,
    postal_code VARCHAR(10) NOT NULL
);

CREATE TABLE tb_recipient(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    address_id UUID NOT NULL,
    FOREIGN KEY (address_id) REFERENCES tb_address(id)
);

CREATE TABLE tb_delivery(
    id UUID NOT NULL PRIMARY KEY,
    tracking_code VARCHAR(64) NOT NULL UNIQUE,
    status VARCHAR(12) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    delivery_date TIMESTAMP NOT NULL,
    recipient_id UUID,
    CONSTRAINT chk_status CHECK(status in ('PENDING', 'DISPATCHED', 'IN_TRANSIT', 'DELIVERED')),
    FOREIGN KEY (recipient_id) REFERENCES tb_recipient(id)
);

CREATE TABLE tb_product(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(255),
    weight NUMERIC(10,2) NOT NULL,
    quantity NUMERIC NOT NULL,
    delivery_id UUID,
    FOREIGN KEY (delivery_id) REFERENCES tb_delivery(id)
);
