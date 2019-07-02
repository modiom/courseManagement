package com.project.courses.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.entity.TrainerAllocation;
import com.project.courses.demo.model.Timesheet;
import com.project.courses.demo.service.TrainerAllocationService;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/trainerAllocation")
public class TrainerAllocationController {
	
	  @Autowired TrainerAllocationService service;
	  
	    @GetMapping
	    public List<TrainerAllocation> getTimesheet() {
	        return service.getTimesheet();

	    }

	    @PostMapping
	    public void addTimetable(@RequestBody List<Timesheet> cto) {
	    	System.out.println(cto.toString());
	        service.addTimesheet(cto);

	    }
	    
	    @PostMapping("/update")
	    public void updateTimetable(@RequestBody Timesheet cto) {
			service.updateTimesheet(cto);

		}
	   
	    @DeleteMapping("/delete/{id}")
	    public void deleteTimetable(@PathVariable(required=true) int id) {
			service.deleteTimetable(id);

		}

	    @GetMapping("/{id}")
	    public TrainerAllocation getById(@PathVariable(required = true) int id) {

	        return service.getById(id);

	    }

	   
	
}
