INSERT INTO "user" (username, password, email, role) VALUES
('Admin', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'admin@example.com', 'ADMIN'),

('Barber John', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'john@barber.com', 'PROVIDER'),
('Stylist Anna', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'anna@style.com', 'PROVIDER'),
('Masseur Tom', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'tom@massage.com', 'PROVIDER'),

('User One', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'user1@example.com', 'USER'),
('User Two', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'user2@example.com', 'USER'),
('User Three', '$2a$10$DBcZCOGIcrD3y82OXbVjuun6B1eODlvLEkKEe3DrrQWqSNYoIyg32', 'user3@example.com', 'USER');

INSERT INTO service_entity (name, description, price, provider_id) VALUES
('Strzyżenie męskie', 'Klasyczne strzyżenie', 50.0, 2),
('Broda + Strzyżenie', 'Pełny pakiet barberski', 80.0, 2),

('Strzyżenie damskie', 'Strzyżenie + modelowanie', 120.0, 3),
('Koloryzacja', 'Farbowanie włosów', 250.0, 3),
('Upięcie okolicznościowe', 'Fryzura na wesele', 180.0, 3),

('Masaż klasyczny', 'Relaksacyjny masaż całego ciała', 150.0, 4),
('Masaż sportowy', 'Regeneracja mięśni', 200.0, 4);

INSERT INTO availability (start_time, end_time, provider_id) VALUES
('2026-03-01 09:00:00', '2026-03-01 17:00:00', 2),
('2026-03-02 09:00:00', '2026-03-02 17:00:00', 2),

('2026-03-01 10:00:00', '2026-03-01 18:00:00', 3),
('2026-03-03 09:00:00', '2026-03-03 17:00:00', 3),

('2026-03-01 08:00:00', '2026-03-01 16:00:00', 4),
('2026-03-04 12:00:00', '2026-03-04 20:00:00', 4);

INSERT INTO appointment (start_time, end_time, user_id, provider_id, service_id) VALUES
('2026-03-01 10:00:00', '2026-03-01 10:30:00', 5, 2, 1),
('2026-03-01 11:00:00', '2026-03-01 12:00:00', 6, 3, 3),
('2026-03-01 14:00:00', '2026-03-01 15:00:00', 7, 4, 6);
