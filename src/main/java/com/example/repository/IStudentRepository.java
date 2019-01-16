package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public interface IStudentRepository {
	
	public List<Student> findAll();

	public Student findById(int id);
	
	public Student save(Student student);
	
	public Student update(Student student, int id);
	
	public boolean delete(int id);
}
