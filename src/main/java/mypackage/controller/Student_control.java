package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Student;
import mypackage.service.Student_Services;

@RestController
@RequestMapping("/api")
public class Student_control {

	@Autowired
	Student_Services s_serv;
	
	@GetMapping("student")
	public List<Student> getStudents() {
		return s_serv.getAllStudents();
	}
	
	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable int id) {
		return s_serv.getStudentsById(id);
	}
	
	
	
	@PostMapping("student")
	public String addStudent(@RequestBody Student st) {
		return s_serv.addStudent(st);
	}
	
	@PatchMapping("student")
	public String updateOnlyField( @RequestBody Student st) {
		return s_serv.updateSomeDetails(st);
	}
	
	@PutMapping("student")
	public String updateStudent(@RequestBody Student st) {
		return s_serv.updateStudentDetails(st);
	}
	
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return s_serv.deleteStudent(id);
	}
	
}
