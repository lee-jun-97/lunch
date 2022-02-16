package com.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunch.vo.MainVO;

public interface LunchRepository extends JpaRepository<MainVO, Long>{

}
