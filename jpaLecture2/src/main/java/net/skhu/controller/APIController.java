package net.skhu.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Professor;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.StudentRepository;
import net.skhu.repository.StudentRepository3;

@RestController
@RequestMapping("api")
public class APIController {

	@Autowired DepartmentRepository departmentRepository;
	@Autowired StudentRepository3 studentRepository;
	@Autowired ProfessorRepository professorRepository;

	@RequestMapping("departments")
	public List<Department> departments() {
		return departmentRepository.findAll();
	}

	@RequestMapping("students")
	public List<Student> students() {	// 전체 학생 목록을 출력
		return studentRepository.findAll();
	}

	@RequestMapping("department/{id}/students")
	public List<Student> departmentStudents(@PathVariable("id") int id) {	// id값에 해당하는 학과의 학생 목록을 출력
		Department department = departmentRepository.findById(id).get();
		return department.getStudents();
	}

	@RequestMapping("department/{id}/professors")
	public List<Professor> departmentProfessors(@PathVariable("id") int id) {
		Department department = departmentRepository.findById(id).get();
		return department.getProfessors();
	}

	@RequestMapping("student/{id}/registrations")
	public List<Registration> studentRegistrations(@PathVariable("id") int id) {
		Student student = studentRepository.findById(id).get();
		return student.getRegistrations();
	}
	
	/*
	@RequestMapping("student/{id}/courses")
	public List<Course> studentCourses(@PathVariable("id") int id) {	// id값에 해당하는 학생의 수강 목록을 출력
		Student student = studentRepository.findById(id).get();
		List<Course> list = new ArrayList<Course>();
		for (Registration r : student.getRegistrations())
			list.add(r.getCourse());
		return list;
	}
	*/
	
	//Stream API 활용
	@RequestMapping("student/{id}/courses")
	public Stream<Course> studentCourses(@PathVariable("id") int id) {	// id값에 해당하는 학생의 수강 목록을 출력
		System.out.println(id);
		return studentRepository
				.findById(id).get()
				.getRegistrations()	// 학생 수강목록이 리턴됨
				.stream()			// List<Registration> 으로부터 Registration 객체 스트림을 생성하여 리턴
				.map(s -> s.getCourse());	// Registration 객체 각각에 대해 람다식을 실행 후 리턴하는 Course 객체를 모아서 Stream<Course> 스트림을 리턴

	}
}
