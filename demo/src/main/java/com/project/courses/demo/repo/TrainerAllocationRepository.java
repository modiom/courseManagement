package com.project.courses.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.courses.demo.entity.TrainerAllocation;
import com.project.courses.demo.model.Timesheet;
@Repository
public interface TrainerAllocationRepository  extends CrudRepository<TrainerAllocation, Integer>{

}
