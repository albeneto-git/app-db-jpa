package br.com.estudo.jpa.hibernate.repository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		if(Objects.isNull(course.getId())) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		Course deleteCourse = this.findById(id);
		em.remove(deleteCourse);
	}
}
