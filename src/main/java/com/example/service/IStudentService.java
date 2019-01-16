package com.example.service;

import com.example.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    //Get all students
    public List<Student> getAllStudents();

    //Get student by id
    public Student getStudentById(int id);

    //Create a student
    public Student createStudent(Student student);

    //Update a student
    public Student updateStudent(Student student, int id);

    //Delete a student
    public boolean deleteStudent(int id);
}
