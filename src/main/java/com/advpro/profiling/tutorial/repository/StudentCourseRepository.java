package com.advpro.profiling.tutorial.repository;

import com.advpro.profiling.tutorial.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Optimized repository to fetch StudentCourse entities with their associated
 * Student and Course entities in one query.
 */
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query("SELECT sc FROM StudentCourse sc JOIN FETCH sc.student JOIN FETCH sc.course")
    List<StudentCourse> findAllWithStudentAndCourse();
}
