INSERT INTO carrentaldb.address (id, post_code, street) VALUES (1, '40-852', 'Warszawa Miła 1/80');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (2, '40-852', 'Katowice Poznańska 8/4');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (3, '40-586', 'Gdynia Mysłowicka 5/38');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (4, '44-842', 'Łódź Chorzowska 45/5');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (5, '40-421', 'Kraków Opolska 84/32');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (6, '44-653', 'Kraków Ks. Lipińskiego 74/12');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (7, '48-513', 'Gdynia Gen. Labrynca 74/7');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (8, '40-745', 'Wrocław Św. Joanny Zomerfeld 7/41');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (9, '80-401', 'Bytom Warszawska 2/74');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (10, '90-432', 'Poznań Francuska 21/5');
INSERT INTO carrentaldb.address (id, post_code, street) VALUES (11, '11-741', 'Łódź Fanów Audi 14');

INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 1, 72000, null, 2017, 'HATCHBACK', 'NISSAN', 'CZARNY', 'MICRA');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 2, 63000, null, 2016, 'HATCHBACK', 'KIA', 'SREBRNY', 'CEED');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 3, 56000, null, 2018, 'SEDAN', 'AUDI', 'BIAŁY', 'A4');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 4, 32000, null, 2020, 'KABRIOLET', 'BMW', 'NIEBIESKI', 'M8');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 5, 171000, null, 2015, 'KOMBI', 'TOYOTA', 'CZERWONY', 'AURIS');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 6, 156000, null, 2010, 'VAN', 'MERCEDES', 'SZARY', 'VITO');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 7, 126000, null, 2014, 'MINIVAN', 'OPEL', 'SREBRNY', 'ZAFIRA');
INSERT INTO carrentaldb.cars (branch_id, id, mileage, reservation_id, year, body_type, brand, color, name) VALUES (null, 8, 21000, null, 2016, 'COUPE', 'PORSCHE', 'POMARAŃCZOWY', '911 GT3 RS');

INSERT INTO carrentaldb.main_rental (contact_address_id, id, logo, name, owner) VALUES (1, 1, 'BOA', 'BOA', 'BARTEK');
INSERT INTO carrentaldb.main_rental (contact_address_id, id, logo, name, owner) VALUES (2, 2, 'BOA', 'BOA', 'OLIWER');
INSERT INTO carrentaldb.main_rental (contact_address_id, id, logo, name, owner) VALUES (3, 3, 'BOA', 'BOA', 'ANIA');
INSERT INTO carrentaldb.main_rental (contact_address_id, id, logo, name, owner) VALUES (4, 4, 'BOA', 'BOA', 'JOANNA');

INSERT INTO carrentaldb.users (branch_id, id, email, first_name, last_name, login, password) VALUES (null, 1, 'ania@gmail.com', 'Ania', 'Poznańska', 'Ania', '1234');
INSERT INTO carrentaldb.users (branch_id, id, email, first_name, last_name, login, password) VALUES (null, 2, 'oliwer@gmail.com', 'Oliwer', 'Lipiński', 'Oliwer', '1234');
INSERT INTO carrentaldb.users (branch_id, id, email, first_name, last_name, login, password) VALUES (null, 3, 'bartek@gmail.com', 'Bartek', 'Labrync', 'Bartek', '1234');
INSERT INTO carrentaldb.users (branch_id, id, email, first_name, last_name, login, password) VALUES (null, 4, 'joanna@gmail.com', 'Joanna', 'Zomerfeld', 'Joanna', '1234');
INSERT INTO carrentaldb.users (branch_id, id, email, first_name, last_name, login, password) VALUES (null, 5, 'joanna@gmail.com', 'dfgh', 'sdf', 'azxc', '1234');

INSERT INTO carrentaldb.branches (address_id, id, main_rental_id) VALUES (2, 1, 2);
INSERT INTO carrentaldb.branches (address_id, id, main_rental_id) VALUES (3, 2, 3);
INSERT INTO carrentaldb.branches (address_id, id, main_rental_id) VALUES (4, 3, 4);


