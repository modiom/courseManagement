package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trainer_id")
	private int trainer_id;
	
	@Column(name="trainer_name")
	private String trainerName;
	
	
	
	public Trainer() {}

	public Trainer(String trainer_name) {
		this.trainerName = trainer_name;
		
	}

	
	

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainer_name() {
		return trainerName;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainerName = trainer_name;
	}

	@Override
	public String toString() {
		return "trainer [trainer_id=" + trainer_id + ", trainer_name=" + trainerName +"]";
	}
	
}
