package com.project.courses.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.courses;

@Component
public class courseDaoHibernateImpl implements CoursesDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public courseDaoHibernateImpl(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}

	@Override
	public List<courses> selectAll() {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<courses> theQuery = currentSession.createQuery("from courses", courses.class);
		List<courses> courseList = theQuery.getResultList();
		
				
		return courseList;
	}
	

}
