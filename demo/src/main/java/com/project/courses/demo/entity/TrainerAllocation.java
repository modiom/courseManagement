package com.project.courses.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="trainer_allocation")
public class TrainerAllocation {

		@JsonSerialize
	 	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="trainer_allocation_id")
		private int trainer_allocation_id;
	 
		@JsonSerialize
	 	@OneToOne
	    @JoinColumn(name = "course_id")
	    private Course course;

		@JsonSerialize
		@OneToOne
	    @JoinColumn(name = "trainer_id")
	    private Trainer trainer;
	    
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="end_time")
	    private LocalDateTime end_time;
	    
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="start_time")
	    private LocalDateTime start_time;

		@Override
		public String toString() {
			return "TrainerAllocation [trainer_allocation_id=" + trainer_allocation_id + ", course=" + course
					+ ", trainer=" + trainer + ", end_time=" + end_time + ", start_time=" + start_time + "]";
		}
	    
	  
}
