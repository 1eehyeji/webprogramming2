package net.skhu.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository2;

@RestController
@RequestMapping("api4")
public class API4Controller {

    @Autowired StudentRepository2 studentRepository2;

    @RequestMapping("test1")
    public List<Student> test1() {
        return studentRepository2.findStudents();
    }

    @RequestMapping("test2")
    public List<Student> test2() {
        return studentRepository2.findStudentsByDepartmentId(1);
    }

    @RequestMapping("test3")
    public List<Student> test3() {
        return studentRepository2.findStudentsByStudentNoOrName("200032010", "고은별");
    }

    @RequestMapping("test4")
    public List<Student> test4() {
        return studentRepository2.findStudentsByStudentNoOrName2("200032010", "고은별");
    }

    @RequestMapping("test5")
    public List<Department> test5() {
        return studentRepository2.findDepartmentOfStudents();
    }

    @RequestMapping("test6")
    public List<Department> test6() {
        return studentRepository2.findDistinctDepartmentOfStudents();
    }

    @RequestMapping("test7")
    public List<Course> test7() {
        return studentRepository2.findCourseByStudentNo("200032010");
    }

    @RequestMapping("test8")
    public List<Object[]> test8() {
        return studentRepository2.findIdAndNameOfStudents();
    }

    @RequestMapping("test9")
    public List<Object[]> test9() {
        return studentRepository2.findStudentCountOfDepartment();
    }

    @Transactional // @Modifying 어노테이션이 붙은 메소드를 호출하는 코드를 포함할 때 반드시 붙여야 함
    @RequestMapping("testUpdate1")
    public Student testUpdate1() {
        Student student = studentRepository2.findById(2).get();
        if (student.getName().equals("고은별"))
            studentRepository2.updateStudentName(2, "Go En Byeol");
        else
            studentRepository2.updateStudentName(2, "고은별");
        return studentRepository2.findById(2).get();
    }

    @RequestMapping("testUpdate2")
    public Student testUpdate2() {		// 바람직한 수정 방식
        Student student = studentRepository2.findById(2).get();
        if (student.getName().equals("고은별"))
            student.setName("Go En Byeol");
        else
            student.setName("고은별");
        studentRepository2.save(student); // save 메소드는 DB에 없는 데이터는 삽입해주고 있는 데이터는 수정함
        return studentRepository2.findById(2).get();
    }
    
}
