package com.lunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.vo.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	List<Menu> findByMenu(String input);
	List<Menu> findByNation(String input);
}
