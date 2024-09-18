CREATE TABLE professor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    department TEXT
);

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    email TEXT
);

CREATE TABLE course (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    credits INT,
    professorId INT,
    FOREIGN KEY(professorId) REFERENCES professor(id)
);

CREATE TABLE course_student (
    studentId INT,
    courseId INT,
    PRIMARY KEY(studentId, courseId),
    FOREIGN KEY(studentId) REFERENCES student(id),
    FOREIGN KEY(courseId) REFERENCES course(id)
);