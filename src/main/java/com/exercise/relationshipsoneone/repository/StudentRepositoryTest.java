package com.exercise.relationshipsoneone.repository;

import com.exercise.relationshipsoneone.RelationshipsOneOneApplication;
import com.exercise.relationshipsoneone.entity.Passport;
import com.exercise.relationshipsoneone.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RelationshipsOneOneApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void someTest(){
        repository.someOperationToUnderstandPersistenceContext();
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
       Student student = em.find(Student.class, 20001L);
       logger.info("student -> {}", student);
       logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }
}
