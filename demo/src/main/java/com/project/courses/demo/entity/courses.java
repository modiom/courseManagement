package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="course_name")
	private String course_name;
	
	/*
	 * @Column(name="trainer_id") private int trainer_id;
	 * 
	 * @Column(name="comment") private String comment;
	 */
	public Courses() {}

	public Courses(String course_name/*, int trainer_id, String comment*/) {
		this.course_name = course_name;
		/*
		 * this.trainer_id = trainer_id; this.comment = comment;
		 */
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

	/*
	 * public int getTrainer_id() { return trainer_id; }
	 * 
	 * public void setTrainer_id(int trainer_id) { this.trainer_id = trainer_id; }
	 * 
	 * public String getComment() { return comment; }
	 * 
	 * public void setComment(String comment) { this.comment = comment; }
	 */

	@Override
	public String toString() {
		return "courses [course_id=" + course_id + ", course_name=" + course_name
				+ /*
					 * ", trainer_id=" + trainer_id + ", comment=" + comment +
					 */ "]";
	}
	
	
	
	

}
