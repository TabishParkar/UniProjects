CREATE TABLE Studio (
    studio_id INT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE Services (
  service_id INT PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  price DECIMAL(10, 2),
  studio_id INT,
  FOREIGN KEY (studio_id) REFERENCES Studio(studio_id)
);

CREATE TABLE Instructors (
  instructor_id INT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  phone_number VARCHAR(20),
  studio_id INT,
  FOREIGN KEY (studio_id) REFERENCES Studio(studio_id)
);

CREATE TABLE Classes (
  class_id INT PRIMARY KEY,
  service_id INT,
  date DATE,
  time TIME,
  instructor_id INT,
  FOREIGN KEY (service_id) REFERENCES Services(service_id),
  FOREIGN KEY (instructor_id) REFERENCES Instructors(instructor_id)
);

CREATE TABLE Bookings (
  booking_id INT PRIMARY KEY,
  client_name VARCHAR(255),
  client_email VARCHAR(255),
  client_phone_number VARCHAR(20),
  class_id INT,
  payment_status VARCHAR(20) DEFAULT 'pending',
  FOREIGN KEY (class_id) REFERENCES Classes(class_id)
);

CREATE TABLE Payments (
  payment_id INT PRIMARY KEY,
  booking_id INT,
  amount_paid DECIMAL(10, 2),
  payment_date DATE,
  FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);

INSERT INTO Studio (studio_id, name, address, phone_number, email)
VALUES (1, 'Yoga Bliss', '7 Knight St', '081-545-8940', 'yogabliss@gmail.com');
INSERT INTO Studio (studio_id, name, address, phone_number, email)
VALUES (2, 'Breathing Studio', '7 Knight St', '081-545-8941', 'yogabliisbs@gmail.com');
INSERT INTO Studio (studio_id, name, address, phone_number, email)
VALUES (3, 'Stretching Studio', '7 Knight St', '081-545-8942', 'yogablissss@gmail.com');
INSERT INTO Studio (studio_id, name, address, phone_number, email)
VALUES (4, 'Advanced Studio', '7 Knight St', '081-545-8943', 'yogablissas@gmail.com');
INSERT INTO Studio (studio_id, name, address, phone_number, email)
VALUES (5, 'Full Body Studio', '7 Knight St', '081-545-8944', 'yogablissfb@gmail.com');

INSERT INTO Services (service_id, name, description, price, studio_id)
VALUES (1, 'Hatha Yoga', 'A yoga class focuses on physical postures and breathing techniques', 15.00, 1);
INSERT INTO Services (service_id, name, description, price, studio_id)
VALUES (2, 'Breathing Class ', 'A total beginner''s breathing class focusing on breathing techniques', 25.00, 2);
INSERT INTO Services (service_id, name, description, price, studio_id)
VALUES (3, 'Stretching Class ', 'A stretching class which focuses on stretching techniques', 30.00, 3);
INSERT INTO services (service_id, name, description, price, studio_id)
VALUES (4, 'Advanced Class ', 'An advanced class which focuses on combining all techniques', 35.00, 4);
INSERT INTO services (service_id, name, description, price, studio_id)
VALUES (5, 'Full Body Class ', 'A full body workout class which focuses on all techniques', 40.00, 5);

INSERT INTO Instructors (instructor_id, name, email, phone_number, studio_id)
VALUES (1, 'John Doe', 'johndoe@example.com', '555-555-5558', 1);
INSERT INTO Instructors (instructor_id, name, email, phone_number, studio_id)
VALUES (2, 'James May', 'jamesmay@gmail.com', '061-251-3598', 2);
INSERT INTO Instructors (instructor_id, name, email, phone_number, studio_id)
VALUES (3, 'Jeremy Clarkson', 'jeremyclarkson@gmail.com', '087-368-1658', 3);
INSERT INTO Instructors (instructor_id, name, email, phone_number, studio_id)
VALUES (4, 'Richard Hammond', 'richardhammond@gmail.com', '084-387-1384', 4);
INSERT INTO Instructors (instructor_id, name, email, phone_number, studio_id)
VALUES (5, 'Oliver Kew', 'oliverkew@gmail.com', '078-642-8526', 5);

INSERT INTO Classes (class_id, service_id, date, time, instructor_id)
VALUES (1, 1, '2024-01-01', TIME('09:00:00'), 1);
INSERT INTO Classes (class_id, service_id, date, time, instructor_id)
VALUES (2, 2, '2024-01-02', TIME('17:00:00'), 2);
INSERT INTO Classes (class_id, service_id, date, time, instructor_id)
VALUES (3, 3, '2024-01-03', TIME('10:30:00'), 3);
INSERT INTO Classes (class_id, service_id, date, time, instructor_id)
VALUES (4, 4, '2024-01-04', TIME('16:00:00'), 4);
INSERT INTO Classes (class_id, service_id, date, time, instructor_id)
VALUES (5, 5, '2024-01-01', TIME('18:00:00'), 5);

INSERT INTO Bookings (booking_id, client_name, client_email, client_phone_number, class_id)
VALUES (1, 'John Doe', 'johndoe@example.com', '555-555-5558', 1);
INSERT INTO Bookings (booking_id, client_name, client_email, client_phone_number, class_id)
VALUES (2, 'Gary Oak', 'garyoak@gmail.com', '067-167-4521', 2);
INSERT INTO Bookings (booking_id, client_name, client_email, client_phone_number, class_id)
VALUES (3, 'Ben Solo', 'bensolo@gmail.com', '082-456-4594', 3);
INSERT INTO Bookings (booking_id, client_name, client_email, client_phone_number, class_id)
VALUES (4, 'Hannibal Lector', 'hlector@gmail.com', '084-654-1579', 4);
INSERT INTO Bookings (booking_id, client_name, client_email, client_phone_number, class_id)
VALUES (5, 'Olivia Chase', 'chaseolivia@gmail.com', '087-657-1545', 5);


INSERT INTO Payments (payment_id, booking_id, amount_paid, payment_date)
VALUES (1, 1, 15.00, '2024-01-01');
INSERT INTO Payments (payment_id, booking_id, amount_paid, payment_date)
VALUES (2, 2, 25.00, '2024-01-02');
INSERT INTO Payments (payment_id, booking_id, amount_paid, payment_date)
VALUES (3, 3, 30.00, '2024-01-01');
INSERT INTO Payments (payment_id, booking_id, amount_paid, payment_date)
VALUES (4, 4, 35.00, '2024-01-10');
INSERT INTO Payments (payment_id, booking_id, amount_paid, payment_date)
VALUES (5, 5, 40.00, '2024-01-01');