package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Student;
import net.skhu.model.Pagination;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	// 페이지 단위로 조회하여 리턴, Pageable객체에 담긴 페이지 번호와 정렬순서가 적용되어 조회결과 리턴
	public Page<Student> findAll(Pageable pageable);
	public Page<Student> findByDepartmentId(int departmentId, Pageable pageable);
	
	public default List<Student> findAll(Pagination pagination) { // findAll을 호출하기 전 필요한 절차를 미리 구현
		Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
											new Sort(Sort.Direction.ASC, "StudentNo")); // 학번 오름차순 정렬
		Page<Student> page = findAll(pageable); //객체에 담긴 값을 적용하여 테이블 조회
		pagination.setRecordCount((int)page.getTotalElements()); //총 페이지 수를 계산하기 위해서, 전체 레코드 수가 필요함
		return page.getContent(); // 조회 결과인 학생 목록을 리턴함
	}
	
	public default List<Student> findByDepartmentId(Pagination pagination) {
		Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
											new Sort(Sort.Direction.ASC, "studentNo"));
		Page<Student> page = findByDepartmentId(pagination.getDi(), pageable);
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}

}
