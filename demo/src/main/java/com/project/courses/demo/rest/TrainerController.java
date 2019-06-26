package com.project.courses.demo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.model.TrainerModel;
import com.project.courses.demo.service.TrainerService;

@RestController
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	@GetMapping(value="/trainer")
	public ResponseEntity<List<TrainerModel>> getTrainers()
	{
		List<TrainerModel> trainers=trainerService.getTrainers();
		return new ResponseEntity<List<TrainerModel>>(trainers,HttpStatus.OK);
	}
	@PostMapping(value="/trainer")
	public ResponseEntity<Void> setTrainer(@RequestBody TrainerModel trainer)
	{
		Boolean isSaved=trainerService.addTrainer(trainer);
		if(isSaved)
		{
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	@GetMapping(value="/trainer/{courseId}")
	ResponseEntity<List<TrainerModel>> getTrainersForCourse(@PathVariable("courseId") Integer courseId)
	{
		List<TrainerModel> trainers=trainerService.getTrainersForCourse(courseId);
		return new ResponseEntity<List<TrainerModel>>(trainers,HttpStatus.OK);
		
	}
	

}
