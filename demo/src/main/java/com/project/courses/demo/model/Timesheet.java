package com.project.courses.demo.model;

import java.time.LocalDateTime;

public class Timesheet {

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int course_id;
	private int trainer_id;
	private int backup_trainer_id;
	private String comment;
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	public int getBackup_trainer_id() {
		return backup_trainer_id;
	}
	public void setBackup_trainer_id(int backup_trainer_id) {
		this.backup_trainer_id = backup_trainer_id;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Timesheet [startTime=" + startTime + ", endTime=" + endTime + ", course_id=" + course_id
				+ ", trainer_id=" + trainer_id + ", backup_trainer_id=" + backup_trainer_id + ", comment=" + comment
				+ "]";
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	
}
