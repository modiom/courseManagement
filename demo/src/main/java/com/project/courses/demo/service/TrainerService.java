package com.project.courses.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.courses.demo.entity.Course;
import com.project.courses.demo.entity.CourseTrainer;
import com.project.courses.demo.entity.Trainer;
import com.project.courses.demo.model.CourseModel;
import com.project.courses.demo.model.TrainerModel;
import com.project.courses.demo.repo.CourseTrainerRepository;
import com.project.courses.demo.repo.TrainerRepository;
@Component
public class TrainerService {
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	private CourseTrainerRepository courseTrainerRepository;
	public List<TrainerModel> getTrainers()
	{
		List<Trainer> trainers=(List<Trainer>) trainerRepository.findAll();
		List<TrainerModel> trainersDto=new ArrayList<>();
		for(Trainer trainer:trainers)
		{
			TrainerModel tm=new TrainerModel(trainer.getTrainer_id(), trainer.getTrainer_name(), new ArrayList<CourseModel>());
			List<CourseTrainer> courseTrainers=courseTrainerRepository.findByTrainer(trainer);
			for(CourseTrainer courseTrainer:courseTrainers)
			{
				CourseModel cm=new CourseModel();
				cm.setCourse_name(courseTrainer.getCourse().getCourse_name());
				cm.setCourse_id(courseTrainer.getCourse().getCourse_id());
				tm.getCourses().add(cm);
			}
			trainersDto.add(tm);
		}
		return trainersDto;
	}
	public Boolean addTrainer(TrainerModel trainerDto)
	{
		Trainer trainer=trainerRepository.findByTrainerName(trainerDto.getTrainerName());
		if(trainer!=null)
		{
			return false;
		}
		else
		{
			trainer=new Trainer();
			trainer.setTrainer_name(trainerDto.getTrainerName());
			List<CourseTrainer> courseTrainers=new ArrayList<>();
			for(CourseModel course:trainerDto.getCourses())
			{
				Course courseEntity=new Course();
				courseEntity.setCourse_id(course.getCourse_id());
				courseEntity.setCourse_name(course.getCourse_name());
				CourseTrainer courseTrainer=new CourseTrainer();
				courseTrainer.setCourse(courseEntity);
				courseTrainer.setTrainer(trainer);
				courseTrainers.add(courseTrainer);
			}
			trainerRepository.save(trainer);
			courseTrainerRepository.saveAll(courseTrainers);
			
			return true;
		}
	}

}