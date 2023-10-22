package br.com.estudo.jpa.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo.jpa.hibernate.entity.Course;
import br.com.estudo.jpa.hibernate.repository.CourseRepository;

@SpringBootApplication
public class AppDbJpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppDbJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course = repository.findById(1001L);
		logger.info("Course 1001L -> {}", course);
	}

}
