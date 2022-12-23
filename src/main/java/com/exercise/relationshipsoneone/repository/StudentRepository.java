package com.exercise.relationshipsoneone.repository;

import com.exercise.relationshipsoneone.entity.Passport;
import com.exercise.relationshipsoneone.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long idStudent) {
        return em.find(Student.class, idStudent);
    }

    public Student save(Student student) {

        if (student.getIdStudent() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long idStudent) {
        Student student = findById(idStudent);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Ayunda");
        student.setPassport(passport);
        em.persist(student);

    }

    void someOperationToUnderstandPersistenceContext(){
        // Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        // Persistence Context (Student)

        // Database Operation 2 - Reterieve passport
        Passport passport = student.getPassport();
        // Persistence Context (Student, passport)

        // Database Operation 3 - update passport
        passport.setNumber("E123457");
        // Persistence Context (Student, passport++)

        // Database Operation 4 - update student
        student.setName("Rangga - updated");
        // Persistence Context (Student++, Passport++)
    }
}
