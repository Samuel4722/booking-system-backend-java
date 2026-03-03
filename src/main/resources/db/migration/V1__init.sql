CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE service_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION NOT NULL,
    provider_id BIGINT NOT NULL,
    CONSTRAINT fk_service_provider FOREIGN KEY (provider_id) REFERENCES "user"(id)
);

CREATE TABLE availability (
    id BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    provider_id BIGINT NOT NULL,
    CONSTRAINT fk_availability_provider FOREIGN KEY (provider_id) REFERENCES "user"(id)
);

CREATE TABLE appointment (
    id BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    provider_id BIGINT NOT NULL,
    service_id BIGINT NOT NULL,
    CONSTRAINT fk_appointment_user FOREIGN KEY (user_id) REFERENCES "user"(id),
    CONSTRAINT fk_appointment_provider FOREIGN KEY (provider_id) REFERENCES "user"(id),
    CONSTRAINT fk_appointment_service FOREIGN KEY (service_id) REFERENCES service_entity(id)
);
