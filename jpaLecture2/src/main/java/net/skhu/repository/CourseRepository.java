package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("select c from Course c join c.registrations r where r.student.id = ?1")
	List<Course> findByStudentId(int id);
	
	List<Course> findByProfessorId(int id);
	
	@Query("select c from Course c where professorId = ?1")
	List<Course> findByProfessorId2(int id);
}
