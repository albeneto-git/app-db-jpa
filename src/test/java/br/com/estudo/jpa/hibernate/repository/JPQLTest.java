package br.com.estudo.jpa.hibernate.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.estudo.jpa.hibernate.AppDbJpaApplication;
import br.com.estudo.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes = AppDbJpaApplication.class)
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		List resultList = em.createQuery("select c from Course c").getResultList();
		logger.info(" *** select c from Course c BASIC -> {}", resultList);
	}	

	@Test
	public void jpql_type() {
		TypedQuery<Course> createQuery = em.createQuery("select c from Course c", Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info(" *** select c from Course c TYPE -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> createQuery = em.createQuery("select c from Course c where name like '%17%'", Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info(" *** select c from Course c WHERE -> {}", resultList);
	}

}
