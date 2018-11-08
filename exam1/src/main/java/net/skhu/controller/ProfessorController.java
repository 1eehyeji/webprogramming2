package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("/c201632025")
public class ProfessorController {

	@Autowired ProfessorMapper professorMapper;
	@Autowired DepartmentMapper departmentMapper;

	@RequestMapping("list1")
	public String list1(Model model) {
		List<Professor> professors = professorMapper.findAll();
		model.addAttribute("professors", professors);
		return "c201632025/list1";
	}

	@RequestMapping(value="list2")
    public String list2(Model model, @RequestParam("departmentId") int departmentId) {
        List<Professor> professors = professorMapper.findBydepartmentId(departmentId);
        model.addAttribute("professors", professors);
        model.addAttribute("departmentId", departmentId);
        return "c201632025/list2";
    }
	@RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
		Professor professor = professorMapper.findOne(id);
		System.out.println(professor.getProfessorName());
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("professor", professor);
        model.addAttribute("departments", departments);
        return "c201632025/edit";
    }
}
