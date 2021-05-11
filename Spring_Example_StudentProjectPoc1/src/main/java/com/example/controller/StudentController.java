package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.StudentService;
import com.example.student.Student;

@RestController
@RequestMapping("/app/Student")
public class StudentController {
	@Autowired
	private StudentService service;
	//creating student
		@PostMapping("/create")
		public Student createStudent(@RequestBody Student student) {
			return service.createStudent(student);
		}
	@GetMapping("/getAllStudents/{num}")
	public Iterable<Student> getAllStudents(@PathVariable("num") Integer num) {
		return  service.paginatation(num);
	}

	// get a student
	@GetMapping("/student/{sId}")
	public Optional<Student> getStudent(@PathVariable("sId") Integer sId) {
		return service.getStudent(sId);
	}

	// Delete a student
	@DeleteMapping("/student/{sid}")
	public void deleteStudent(@PathVariable("sId") Integer sId) {
		service.deleteStudent(sId);
	}
	
	// update a student
	@PutMapping("/student/{sId}/{newEmail}")
	public Student updateStudent(@PathVariable("sId") Integer sId, @PathVariable("newEmail") String newEmail) {
		return service.updateStudent(sId, newEmail);
	}
}
