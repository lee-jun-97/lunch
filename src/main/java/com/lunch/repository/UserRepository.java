package com.lunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email);
	List<User> findByName(String name);
}
