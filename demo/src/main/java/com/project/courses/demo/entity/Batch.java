package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@Column(name="batch_id")
	private int batchId;
	
	@Column(name="batch_name")
	private String batchName;
	
	
}
