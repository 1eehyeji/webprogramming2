package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Register;

@Mapper
public interface RegisterMapper {
	List<Register> findAll();
	Register findOne(int id);
	List<Register> findByUserId(String userId);	
	List<Register> findByUserIdByCode(String st, String userId);
	List<Register> findByUserIdByName(String st, String userId);
	List<Register> findByCode(String st);
	List<Register> findByName(String st);
	void insert(List<Register> registers);
}
