package com.mutant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column
	private int count_mutant_dna;
	
	@Column
	private int count_human_dna;
	
	@Column
	private float ratio;
	
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public int getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	
	

}
