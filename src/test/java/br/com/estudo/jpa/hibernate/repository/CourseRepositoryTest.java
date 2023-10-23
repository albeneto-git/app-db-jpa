package br.com.estudo.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import br.com.estudo.jpa.hibernate.AppDbJpaApplication;
import br.com.estudo.jpa.hibernate.entity.Course;

@SpringBootTest(classes = AppDbJpaApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository repository;

	@Test
	void findById_basic() {
		Course course = repository.findById(1001L);
		assertEquals("JPA e Hibernate", course.getName());
	}	
	
	@Test
	@DirtiesContext
	void deleteById_basic() {
		repository.deleteById(1002L);
		assertNull(repository.findById(1002L));
	}
	
	@Test
	@DirtiesContext
	void save_basic() {
		Course course = repository.findById(1001L);
		course.setName("Phyton");
		Course saveCourse = repository.save(course);
		assertEquals("Phyton", saveCourse.getName());
	}

}
