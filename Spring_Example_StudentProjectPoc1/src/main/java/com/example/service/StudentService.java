package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.dao.StudentDao;
import com.example.student.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public Student createStudent(Student student) {
		return studentDao.save(student);
	}

	public Iterable<Student> paginatation(Integer num) {
		return studentDao.findAll(PageRequest.of(num, 2)).getContent();
	}

	public Optional<Student> getStudent(Integer sId) {
		return studentDao.findById(sId);
	}

	public void deleteStudent(Integer sId) {
		studentDao.deleteById(sId);
	}

	public Student updateStudent(Integer sId, String emailId) {
		Student ticket = studentDao.findById(sId).orElse(new Student());
		ticket.setEmailId(emailId);
		return studentDao.save(ticket);
	}

	

	

}
