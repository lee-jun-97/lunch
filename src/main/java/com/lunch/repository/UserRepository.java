package com.lunch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lunch.vo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Transactional
	@Modifying
	@Query("update User user set user.use_YN = :use_YN, user.dead_date = :dead_date where user.email = :email")
	int updateUser(@Param("email")String email, @Param("dead_date")String dead_date, @Param("use_YN")String use_YN);
	
	@Transactional
	@Modifying
	@Query("update User user set user.use_YN = :use_YN, user.join_date = :join_date, user.dead_date = :dead_date where user.email = :email")
	int updateUser(@Param("email")String email, @Param("join_date")String join_date, @Param("dead_date")String dead_date, @Param("use_YN")String use_YN);
	
	User findByEmail(String email);
	User findByName(String name);
	User findByEmailAndName(String email, String name);
	
	List<User> findByUseYN(String use_YN);
}
