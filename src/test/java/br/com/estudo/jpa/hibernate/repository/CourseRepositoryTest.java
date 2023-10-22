package br.com.estudo.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.estudo.jpa.hibernate.AppDbJpaApplication;
import br.com.estudo.jpa.hibernate.entity.Course;

@SpringBootTest(classes = AppDbJpaApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;

	@Test
	void contextLoads() {
		Course course = repository.findById(1001L);
		assertEquals("JPA e Hibernate", course.getName());
		logger.info("Test is running...");
	}

}
