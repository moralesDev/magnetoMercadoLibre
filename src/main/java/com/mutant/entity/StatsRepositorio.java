package com.mutant.entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface StatsRepositorio extends Repository<Stats, Integer> {
	ArrayList<Stats>findAll();
	Stats findById(int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE mutanteBD.stats SET count_mutant_dna = count_mutant_dna + 1 WHERE id = :id", 
			  nativeQuery = true)
	int updateCountMutant(int id);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE mutanteBD.stats SET count_human_dna = count_human_dna + 1 WHERE id = :id", 
			  nativeQuery = true)
	int updateCountHuman(int id);
}
