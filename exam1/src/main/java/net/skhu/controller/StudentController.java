package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("/home")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired DepartmentMapper departmentMapper;

	@RequestMapping("test1")
	public String test1(Model model) {
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments", departments);
		return "home/test1";
	}

	@RequestMapping("test2")
	public String test2(Model model) {
		model.addAttribute("number", 123);
		return "home/test2";
	}



	@RequestMapping("list")
	public String list(Model model) {
		List<Student> students = studentMapper.findAll();
		model.addAttribute("students", students);
		return "home/list";
	}

	@RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        Student student = new Student(); //새로운 학생 객체 생성
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student); // 빈 객체를 파라미터 값으로 전달
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, Student student) {
        studentMapper.insert(student); // 내용을 채운 학생 객체를 insert
        return "redirect:list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Student student = studentMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, Student student) {
        studentMapper.update(student);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentMapper.delete(id);
        return "redirect:list";
    }
}
