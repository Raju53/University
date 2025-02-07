package com.example.university.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;

// Write your code here

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseid")
    private int courseId;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "credits")
    private String credits;

    @ManyToOne
    @JoinColumn(name = "professor")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "courseid"), inverseJoinColumns = @JoinColumn(name = "studentid"))
    @JsonIgnoreProperties("courses")
    private List<Student> students;

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}