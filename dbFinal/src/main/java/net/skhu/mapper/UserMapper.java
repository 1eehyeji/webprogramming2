package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	User findOne(String id);
	void insert(User user);
	void update(User user);
	List<User> findById(String st);
	List<User> findByName(String st);
}
