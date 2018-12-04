package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Professor;
import net.skhu.repository.CourseRepository;
import net.skhu.repository.ProfessorRepository;

@RestController
@RequestMapping("api6")
public class API6Controller {
	
	@Autowired ProfessorRepository professorRepository;
	@Autowired CourseRepository courseRepository;
	
	@RequestMapping(value="professor/{id}/courses1")
	public List<Course> professorCourses1(@PathVariable("id") int id) {
		Professor professor = professorRepository.findById(id).get();
		List<Course> list = professor.getCourses();
		return list;
	}
	
	@RequestMapping(value="professor/{id}/courses2")
	public List<Course> professorCourses2(@PathVariable("id") int id) {
		return courseRepository.findByProfessorId(id);
	}
	
	@RequestMapping(value="professor/{id}/courses3")
	public List<Course> professorCourses3(@PathVariable("id") int id) {
		return courseRepository.findByProfessorId2(id);
	}
}
