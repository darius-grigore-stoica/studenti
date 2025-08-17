CREATE DATABASE facultate;
USE facultate;
DELETE FROM student where nume = "Andrei";

CREATE TABLE student(
	studentID INT auto_increment PRIMARY KEY,
	nume VARCHAR(50),
    varsta INT,
    grupa VARCHAR(10)
);

ALTER TABLE student
MODIFY COLUMN nume VARCHAR(20) UNIQUE;

INSERT INTO student VALUES (5, "AndreiAndrei", 19, "325");

INSERT INTO student VALUES (1, "Andrei", 19, "325");

INSERT INTO student VALUES (7, "Mihai", 19, "324");

SELECT * FROM student;

CREATE TABLE nota (
	notaID INT AUTO_INCREMENT PRIMARY KEY,
    valoare INT CHECK(valoare >= 1 AND valoare <= 10),
    studentNota INT, 
    FOREIGN KEY (studentNota) REFERENCES student(studentID)
);

ALTER TABLE nota
MODIFY COLUMN materie VARCHAR(50) NOT NULL;

INSERT INTO nota VALUES(100, 8, 4, "Matematica");
INSERT INTO nota VALUES(102, 10, 4, "Fizica 2");
INSERT INTO nota VALUES(101, 6, 7, "Rezistanta Materialelor");


SELECT * FROM nota;

SELECT valoare, materie, student.nume FROM nota
INNER JOIN student ON nota.studentNota = student.studentID
WHERE student.nume = "Andrei";