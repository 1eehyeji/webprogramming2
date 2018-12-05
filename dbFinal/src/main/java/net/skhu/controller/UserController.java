package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.User;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired UserMapper userMapper;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userMapper.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public String search(Model model, @RequestParam("sb") String sb, @RequestParam("st") String st) {
		List<User> users;
		switch(sb) {
			case "1":
				users = userMapper.findById("%" + st + "%");
				break;
			case "2":
				users = userMapper.findByName("%" + st + "%");
				break;
			default :
				users = userMapper.findAll();
		}
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Model model, User user) {
		userMapper.insert(user);
		return "redirect:login";
	}
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public String myPage(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", userMapper.findOne(user.getId()));
		System.out.println(">>" + user.getId());
		System.out.println(user.getDepartment());
		return "user/myPage";
	}
	
	@RequestMapping(value="myPage", method=RequestMethod.POST)
	public String myPage(Model model, User user) {
		userMapper.update(user);
		return "redirect:myPage";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Model model, User user, HttpSession session) {
		String userId = user.getId();
		User u = userMapper.findOne(userId);
		String password = user.getPassword();
		if(password.equals(u.getPassword())) {
			session.setAttribute("user", u);
			return "redirect:myPage";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
}
