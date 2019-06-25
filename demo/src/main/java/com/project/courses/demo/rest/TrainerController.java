package com.project.courses.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.model.TrainerModel;

@RestController
public class TrainerController {
	@GetMapping(value="/trainer")
	public ResponseEntity<List<TrainerModel>> getTrainers()
	{
		List<TrainerModel> trainers=null;
		return new ResponseEntity<List<TrainerModel>>(trainers,HttpStatus.OK);
	}
	@PostMapping(value="/trainer")
	public ResponseEntity<Void> setTrainer(@RequestBody TrainerModel trainer)
	{
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
