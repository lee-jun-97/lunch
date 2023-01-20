package com.lunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.domain.History;
import com.lunch.domain.Menu;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>{
	void saveAll(List<Menu> list, String date);
}
