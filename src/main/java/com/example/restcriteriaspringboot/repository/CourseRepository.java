package com.example.restcriteriaspringboot.repository;

import com.example.restcriteriaspringboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Query(value = "select c.* from course c " +
            "join student_course s2c on c.id = s2c.course_id " +
            "join student s ON s2c.student_id = s.id " +
            "where s.student_name =:name", nativeQuery = true)
    List<Course> findAllByStudentName(@Param("name") String name);

    @Query(value = "select * from course where course_cost = (SELECT MAX(course.course_cost) from course)", nativeQuery = true)
   List<Course> findExpensiveCourse();


}
