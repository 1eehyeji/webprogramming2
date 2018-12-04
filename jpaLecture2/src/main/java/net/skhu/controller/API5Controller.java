package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.CourseRepository;
import net.skhu.repository.RegistrationRepository;
import net.skhu.repository.StudentRepository2;
import net.skhu.repository.StudentRepository3;

@RestController
@RequestMapping("api5")
public class API5Controller {

	@Autowired StudentRepository3 studentRepository3;	// 기본메소드
	@Autowired StudentRepository2 studentRepository2;
	@Autowired RegistrationRepository registrationRepository;
	@Autowired CourseRepository courseRepository;
	
	@RequestMapping(value="student/{id}/courses1")	// jpa 기본 메소드로 구현
	public List<Course> studentCourses1(@PathVariable("id") int id) {
		Student student = studentRepository3.findById(id).get();
		List<Course> list = new ArrayList<Course>();
		for(Registration r : student.getRegistrations()) {
			list.add(r.getCourse());
		}
		return list;
	}
	
	@RequestMapping(value="student/{id}/courses2")
	public List<Course> studentCourses2(@PathVariable("id") int id) {
		List<Course> list = new ArrayList<Course>();
		for(Registration r : registrationRepository.findByStudentId(id)) {
			list.add(r.getCourse());
		}
		return list;
	}
	
	@RequestMapping(value="student/{id}/courses3")
	public List<Course> studentCourses3(@PathVariable("id") int id) {
		return courseRepository.findByStudentId(id);
	}
}
