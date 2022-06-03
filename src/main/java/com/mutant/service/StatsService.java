package com.mutant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutant.entity.StatsRepositorio;
import com.mutant.entity.Stats;

@Service
public class StatsService {
	
	@Autowired
	StatsRepositorio repo;
	
	public ArrayList<Stats> obtenerDatos(){
		return (ArrayList<Stats>) repo.findAll();
	}
	
	public int countMutant(int id) {
		return repo.updateCountMutant(id);
	}
	
	public int countHuman(int id) {
		return repo.updateCountHuman(id);
	}


}
