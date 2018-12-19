package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.domain.Department;
import net.skhu.domain.User;
import net.skhu.model.UserRegistrationModel;
import net.skhu.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public boolean hasErrors(UserRegistrationModel userModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return true;
		if(userModel.getPassword1().equals(userModel.getPassword2()) == false) {
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return true;
		}
		User user = userRepository.findByUserid(userModel.getUserid());
		if(user != null) {
			bindingResult.rejectValue("userid", null, "사용자 아이디가 중복됩니다.");
			return true;
		}
		return false;
	}
	
	public User createEntity(UserRegistrationModel userModel) {
		User user = new User();
		user.setUserid(userModel.getUserid());user.setPassword(userModel.getPassword1());
        user.setName(userModel.getName());
        user.setEmail(userModel.getEmail());
        user.setDepartment(new Department());
        user.getDepartment().setId(userModel.getDepartmentId());
        user.setEnabled(true);
        user.setUserType("학생");
        return user;
	}
	
	public void save(UserRegistrationModel userModel) {
		User user = createEntity(userModel);
		userRepository.save(user);
	}
}
