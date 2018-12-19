package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserid(String userid); // 규칙에 맞는 메소드 이름을 정해주면, jpa에 의해서 자동 생성
}
