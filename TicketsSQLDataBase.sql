BEGIN TRANSACTION;

CREATE TABLE event 
(
event_id serial,
event_name varchar(100) NOT NULL,
event_date DATE NOT NULL,

CONSTRAINT  pk_event PRIMARY KEY (event_id)

);

----------
CREATE TABLE section
(
section_id serial,
section_name varchar(20) NOT NULL,
section_price money NOT NULL,

CONSTRAINT pk_section PRIMARY KEY (section_id),

);

----------
CREATE TABLE row
(
row_id serial,
row_name varchar(3) NOT NULL,
section_id int NOT NULL,

CONSTRAINT pk_row PRIMARY KEY (row_id),
CONSTRAINT fk_row_section_id FOREIGN KEY (section_id) REFERENCES section (section_id)

);

----------
CREATE TABLE seat
(
seat_id serial NOT NULL,
row_id int NOT NULL,
seat_number int NOT NULL,

CONSTRAINT pk_seat PRIMARY KEY (seat_id),
CONSTRAINT fk_seat_row_id FOREIGN KEY (row_id) REFERENCES row (row_id)

);

----------
CREATE TABLE buyer
(
buyer_id serial,
first_name varchar(30),
last_name varchar(30),

CONSTRAINT pk_buyer PRIMARY KEY (buyer_id)

);

----------
CREATE TABLE ticket
(
ticket_id serial,
event_id int NOT NULL,
section_id int NOT NULL,
row_id int NOT NULL,
seat_id int NOT NULL,
buyer_id int NOT NULL,
purchased boolean NOT NULL,
ticket_date TIMESTAMP NOT NULL,

CONSTRAINT pk_ticket PRIMARY KEY (ticket_id),
CONSTRAINT fk_ticket_event_id FOREIGN KEY (event_id)  REFERENCES event (event_id),
CONSTRAINT fk_ticket_section_id FOREIGN KEY (section_id)  REFERENCES section (section_id),
CONSTRAINT fk_ticket_row_id FOREIGN KEY (row_id)  REFERENCES row (row_id),
CONSTRAINT fk_ticket_seat_id FOREIGN KEY (seat_id)  REFERENCES seat (seat_id),
CONSTRAINT fk_ticket_buyer_id FOREIGN KEY (buyer_id)  REFERENCES buyer (buyer_id)

);

ALTER TABLE available_tickets ADD event_date date;

END;

SELECT * FROM buyer;
INSERT INTO buyer (first_name, last_name) VALUES ('Test', 'Subject');
UPDATE buyer SET first_name = 'Crazy', last_name = 'Train' WHERE buyer_id = 1;

SELECT * FROM event;
INSERT INTO event (event_name, event_date) VALUES ('Test Event', '10-20-2020');
UPDATE event SET event_name = 'Retest Event', event_date = '10-21-2020' WHERE event_id = 1;

SELECT * FROM section;
INSERT INTO section (section_name, section_price) VALUES ('Test', 300.00);
UPDATE section SET section_name = 'Tester', section_price = 299.99 WHERE section_id = 1;

SELECT * FROM available_tickets WHERE event_name = 'Test An Event Creation';

SELECT * FROM available_tickets WHERE event_name = 'Test';
DELETE FROM available_tickets;
SELECT * FROM available_tickets;