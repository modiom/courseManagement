package com.project.courses.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="trainer_allocation")
public class TrainerAllocation {

	 
	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="trainer_allocation_id")
		private int trainer_allocation_id;
	 
	 @OneToMany
	    @JoinColumn(name = "course_id")
	    private Course course;

		
	    @ManyToMany
	    @JoinColumn(name = "trainer_id")
	    private Trainer trainer;
	    
	    @Column(name="end_time")
	    private LocalDateTime end_time;
	    
	    @Column(name="start_time")
	    private LocalDateTime start_time;
}
