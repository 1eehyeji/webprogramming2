package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.skhu.dto.Register;
import net.skhu.dto.User;
import net.skhu.mapper.RegisterMapper;
import net.skhu.service.ExcelService;

@Controller
@RequestMapping("register")
public class RegisterController {

	@Autowired ExcelService excelService;
	@Autowired RegisterMapper registerMapper;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user.getId());
		List<Register> registers = registerMapper.findByUserId(user.getId());
		model.addAttribute("registers", registers);
		return "register/list";
	}

	@RequestMapping(value="list", method=RequestMethod.POST)
	public String search(Model model, @RequestParam("sb") String sb, @RequestParam("st") String st, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user.getId());
		List<Register> registers;
		switch(sb) {
		case "1":
			registers = registerMapper.findByUserIdByCode("%" + st + "%", user.getId());
			break;
		case "2":
			registers = registerMapper.findByUserIdByName("%" + st + "%", user.getId());
			break;
		default :
			registers = registerMapper.findByUserId(user.getId());
		}
		model.addAttribute("registers", registers);
		return "register/list";
	}

	// 수강한 목록 엑셀 업로드
	@RequestMapping(value="excelUpload", method=RequestMethod.POST)
	public String replace_upload(Model model, @RequestParam("file") MultipartFile file,
			HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");
		List<Register> registers = excelService.getRegister(file.getInputStream(), user.getId());
		registerMapper.insert(registers);
		return "redirect:list";
	}
}
