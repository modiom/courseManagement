package com.project.courses.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.dao.CoursesDao;
import com.project.courses.demo.entity.courses;

@RestController
@RequestMapping("/api")
public class CoursesRestController {
	
	private CoursesDao coursesDao;

	public CoursesRestController(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}
	
	@GetMapping("/courses")
	public List<courses> selectAll(){
		return coursesDao.selectAll();
	}
	
	
}
