package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="course_name")
	private String course_name;
	
	
	
	public Course() {}

	public Course(String course_name) {
		this.course_name = course_name;
		
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	

	@Override
	public String toString() {
		return "courses [course_id=" + course_id + ", course_name=" + course_name +"]";
	}
	
	
	
	

}
