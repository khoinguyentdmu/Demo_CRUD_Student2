package com.example.controller;

import java.util.List;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/Student" )
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * Get all students
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Student> getAllStudents() {

    	/*ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	IStudentService service = (IStudentService) context.getBean("studentService");
        return service.getAllStudents();*/
    	
    	return studentService.getAllStudents();
    }

    /**
     * Get student by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudentById(id);
    }

    /**
     * Create a student
     * @param student
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    /**
     * Update a student
     * @param student
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {

        return studentService.updateStudent(student, id);
    }

    /**
     * Delete a student
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteStudent(@PathVariable int id) {

    	return studentService.deleteStudent(id);
    }
}