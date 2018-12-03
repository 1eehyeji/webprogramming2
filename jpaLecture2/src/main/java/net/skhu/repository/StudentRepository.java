package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByName(String name); // 이름으로 찾기
	List<Student> findByNameStartsWith(String name); // name 변수 값이 포함된 이름 모두 찾음
    List<Student> findByDepartmentName(String name);
    List<Student> findByDepartmentNameStartsWith(String name);

    List<Student> findAllByOrderByName(); // 이름순서로 정렬
    List<Student> findAllByOrderByNameDesc(); // 이름 내림차순으로 정렬
    List<Student> findByDepartmentIdOrderByNameDesc(int id); // departmentId 값이 id 파라미터와 같은 학생들을 이름 내림차순으로 정렬

}
