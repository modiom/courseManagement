package com.project.courses.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.TrainerAllocation;
import com.project.courses.demo.repo.TrainerAllocationRepository;

@Component
public class TrainerAllocationService {

	@Autowired TrainerAllocationRepository repository;
	public List<TrainerAllocation> getTimetable() {
		return (List<TrainerAllocation>) repository.findAll();
	}

}
