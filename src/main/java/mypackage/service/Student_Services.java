package mypackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Student;
import mypackage.repo.Students_Repo;

@Service
public class Student_Services {
	
	@Autowired
	Students_Repo s_repo;
	
	public List<Student> getAllStudents() {
		return s_repo.findAll(); 
	}
	
	public Student getStudentsById(int id) {
	
			return s_repo.findById(id).get();
		 
	}
	
	public String addStudent(Student st ) {
		s_repo.save(st);
		return "Student added";
	}
	
	public String updateStudentDetails(Student st ) {
		try {
			Student obj = s_repo.findById(st.getStudent_id()).get();
			s_repo.save(obj);
			return "Student Details updated";
		} catch (Exception e) {
			return("student not exist");
		}
	}
	public String updateSomeDetails(Student st) {
		 Student obj = s_repo.findById(st.getStudent_id()).get();
		 if(st.getStudent_name()==null) {
			 st.setStudent_name(obj.getStudent_name());
		 }
		 if(st.getEmail()==null) {
			 st.setEmail(obj.getEmail());
		 }
		 if(st.getMobile_number()==0) {
			 st.setMobile_number(obj.getMobile_number());
		 }
		 if(st.getAge()==0) {
			 st.setAge(obj.getAge());
		 }
		 if(st.getBirth_date()==null){
			 st.setBirth_date(obj.getBirth_date());
		 }
		 s_repo.save(st);
		 return "student Details updated ";
		 
	}
	
	public String deleteStudent(int id) {
		Student obj =s_repo.findById(id).get();
		s_repo.delete(obj);
		return "student "+obj.getStudent_name()+" deleted";
		
	}
}
