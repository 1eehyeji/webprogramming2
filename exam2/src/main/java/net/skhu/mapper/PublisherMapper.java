package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Publisher;

@Mapper
public interface PublisherMapper {
	Publisher findOne(int id);
	List<Publisher> findAll();
	void insert(Publisher publisher);
	void update(Publisher publisher);
	void delete(int id);
}
