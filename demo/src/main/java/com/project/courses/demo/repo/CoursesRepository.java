package com.project.courses.demo.repo;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.project.courses.demo.entity.Courses;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, Integer> {}