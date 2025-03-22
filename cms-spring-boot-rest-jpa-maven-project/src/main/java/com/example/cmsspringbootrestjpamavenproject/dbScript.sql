create database Course_Management;
use  Course_Management;
CREATE TABLE Course_details (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(255) NOT NULL,
    location VARCHAR(100),
    course_fee DECIMAL(10, 2),
    instructor_id INT,
     duration_In_Weeks INT,
    course_level  VARCHAR(100) ,
     CONSTRAINT fk_course_instructor_id FOREIGN KEY (instructor_id) REFERENCES instructor_details(instructor_id)
);


select * from course_details;
INSERT INTO course_management.Course_details (course_name , location, course_fee, instructor_Id, duration_In_Weeks, course_level)
VALUES 
    ('Java Programming', 'Mumbai', 50000.00, 1, 12, 'Intermediate'),
    ('Python Programming', 'Thane', 30000.00, 1, 10, 'Intermediate'),
    ('Dotnet Development', 'Delhi', 20000.00, 2, 8, 'Beginner'),
    ('Software Development', 'Pune', 45000.00, 3, 16, 'Advanced'),
    ('SQL Development', 'Pune', 45000.00, 4, 14, 'Intermediate'),
    ('PHP programming', 'Pune', 15000.00, 6, 6, 'Beginner');




create table instructor_details(
	instructor_id int primary key auto_increment,
     instructor_name VARCHAR(255) NOT NULL,
    contact_No VARCHAR(15));
select * from instructor_details;
insert into instructor_details (instructor_name,contact_No) values("John Smith",745698122),
("Sarah Miller",745698122),("Michael Wilson",745698122),('John gates', '123-456-7890'),('Jacky watson', '987-654-3210'),
('Lucy core', '555-123-4567'); 



