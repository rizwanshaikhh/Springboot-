package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {
	
	 List<Election> findByElectionName(String electionName);
	    
	 List<Election> findByElectionDate(LocalDate electionDate);
}
