package com.project.courses.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Course;
import com.project.courses.demo.entity.Trainer;
import com.project.courses.demo.entity.TrainerAllocation;
import com.project.courses.demo.model.Timesheet;
import com.project.courses.demo.repo.CoursesRepository;
import com.project.courses.demo.repo.TrainerAllocationRepository;
import com.project.courses.demo.repo.TrainerRepository;
import com.project.courses.demo.rest.CoursesRestController;

@Component
public class TrainerAllocationService {

	@Autowired TrainerAllocationRepository repository;
	@Autowired TrainerRepository trainerRepository;
	@Autowired CoursesRepository coursesRepository;
	public List<TrainerAllocation> getTimesheet() {
		return (List<TrainerAllocation>) repository.findAll();
	}

	  public void addTimesheet(List<Timesheet> dto) {
	    	
	    	for(Timesheet c : dto) {
	    			repository.save(toEntity(c));
	    		
	    	}

	    }
	  
	  private TrainerAllocation toEntity(Timesheet cto) {
		  
		  	
	        TrainerAllocation entity = new TrainerAllocation();
	        CoursesService c= new CoursesService();
	      
	        //Course course=c.getCoursesById(cto.getCourse_id());
	        Optional<Course> optionalCourse = coursesRepository.findById(cto.getCourse_id());

	        Course course= optionalCourse.orElseThrow(() -> new CourseNotFoundException("Couldn't find a course with id: "));
	       
	        entity.setCourse(course);
	        Trainer trainer=trainerRepository.findByTrainerId(cto.getTrainer_id());
	        entity.setTrainer(trainer);
	        Trainer backupTrainer=trainerRepository.findByTrainerId(cto.getBackup_trainer_id());
	        entity.setBackup_trainer(backupTrainer);
	        entity.setEnd_time(cto.getEndTime());
	        entity.setStart_time(cto.getStartTime());
	       entity.setComment(cto.getComment());
	        
			
	        return entity;

	    }
	  public Timesheet dummy() {
		  Timesheet t=new Timesheet();
		  t.setStartTime(LocalDateTime.of(2012,1, 1, 12, 30));
		  t.setEndTime(LocalDateTime.of(2012,1, 1, 12, 30));
		  return t;
	  }
}
