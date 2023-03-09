package com.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunch.vo.MailHistory;

@Repository
public interface MailHistoryRepository extends JpaRepository<MailHistory, Long>{

}
