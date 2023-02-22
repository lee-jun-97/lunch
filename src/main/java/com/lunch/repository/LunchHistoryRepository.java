package com.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.domain.LunchHistory;

@Repository
public interface LunchHistoryRepository extends JpaRepository<LunchHistory, Integer>{
}
