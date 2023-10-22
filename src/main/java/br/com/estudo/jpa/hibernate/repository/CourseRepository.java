package br.com.estudo.jpa.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.estudo.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
}
