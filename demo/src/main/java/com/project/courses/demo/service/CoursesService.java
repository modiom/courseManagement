package com.project.courses.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Courses;
import com.project.courses.demo.model.CourseModel;
import com.project.courses.demo.repo.CoursesRepository;

@Component
public class CoursesService {
    @Autowired CoursesRepository repository;
    
    public void add(List<CourseModel> dto) {
    	
    	for(CourseModel c : dto) {
    		if(repository.findById(c.getCourse_id()) == null)
    			repository.save(toEntity(c));
    		
    	}

    }

   

    public List<Courses> getCourses() {
    	return (List<Courses>) repository.findAll();

    }

    public Courses getCoursesById(int id) {

        Optional<Courses> optionalCourse = repository.findById(id);

        return optionalCourse.orElseThrow(() -> new CourseNotFoundException("Couldn't find a course with id: " + id));

    }

    private Courses toEntity(CourseModel cto) {

        Courses entity = new Courses();

        entity.setCourse_name(cto.getCourse_name());

		/*
		 * entity.setTrainer_id(cto.getTrainer_id());
		 * 
		 * entity.setComment(cto.getComment());
		 */

        return entity;

    }



}
