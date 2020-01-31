INSERT INTO telephone_company (name) VALUES
('TechDech'), ('SolarSys');

INSERT INTO user (id, name) VALUES
(1, 'Vasya'), (2, 'Petya');

INSERT INTO telephone (number, free) VALUES
('8(123)456-78-90', false),
('8(987)654-32-10', false),
('11-22-33', false),
('22-33-44', false);

INSERT INTO telephone_company_telephones (telephone_company_name, telephones_number) VALUES
('TechDech', '8(123)456-78-90'),
('SolarSys', '8(987)654-32-10'),
('TechDech', '11-22-33'),
('TechDech', '22-33-44');

INSERT INTO user_telephones (user_id, telephones_number) VALUES
(1, '8(123)456-78-90'),
(2, '8(987)654-32-10'),
(1, '11-22-33'),
(1, '22-33-44');