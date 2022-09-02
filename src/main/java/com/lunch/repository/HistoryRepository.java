package com.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.domain.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{
	
}
