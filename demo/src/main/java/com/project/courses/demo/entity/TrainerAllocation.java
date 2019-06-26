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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.serialize.LocalDateDeserializer;
import com.serialize.LocalDateSerializer;


@Entity
@Table(name="trainer_allocation")
public class TrainerAllocation {

		public int getTrainer_allocation_id() {
		return trainer_allocation_id;
	}

	public void setTrainer_allocation_id(int trainer_allocation_id) {
		this.trainer_allocation_id = trainer_allocation_id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

		@JsonSerialize
	 	@Id
		@GeneratedValue
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
		
		@JsonSerialize
		@OneToOne
	    @JoinColumn(name = "backup_trainer_id")
	    private Trainer backup_trainer;
	    
		@JsonDeserialize(using = LocalDateDeserializer.class)  
		@JsonSerialize(using = LocalDateSerializer.class)  
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="end_time")
	    private LocalDateTime end_time;
	    
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="start_time")
	    private LocalDateTime start_time;
		
		@JsonSerialize
		@Column(name="comment")
		private String comment;

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		@Override
		public String toString() {
			return "TrainerAllocation [trainer_allocation_id=" + trainer_allocation_id + ", course=" + course
					+ ", trainer=" + trainer + ", backup_trainer=" + backup_trainer + ", end_time=" + end_time
					+ ", start_time=" + start_time + "]";
		}

		public Trainer getBackup_trainer() {
			return backup_trainer;
		}

		public void setBackup_trainer(Trainer backup_trainer) {
			this.backup_trainer = backup_trainer;
		}

		
	    
	  
}
