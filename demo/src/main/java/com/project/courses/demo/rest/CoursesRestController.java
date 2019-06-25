package com.project.courses.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.entity.Courses;
import com.project.courses.demo.model.CourseModel;
import com.project.courses.demo.service.CoursesService;


@RestController
@RequestMapping("/course")
public class CoursesRestController {
	
	  @Autowired CoursesService service;
	  
	    @GetMapping
	    public List<Courses> getCourses() {
	        return service.getCourses();

	    }

	    @PostMapping
	    public void postCourse(@RequestBody List<CourseModel> cto) {

	        service.add(cto);

	    }

	    @GetMapping("/{id}")
	    public Courses getById(@PathVariable(required = true) int id) {

	        return service.getCoursesById(id);

	    }

	   
	
}
