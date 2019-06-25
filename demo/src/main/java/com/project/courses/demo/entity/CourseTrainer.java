package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_trainer")
public class CourseTrainer {
	
	@OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

	
    @OneToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_trainer_id")
	private int course_trainer_id;	
}
