package com.example.restcriteriaspringboot.repository;

import com.example.restcriteriaspringboot.model.Course;
import com.example.restcriteriaspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select s.* from student s " +
            "join student_course s2c on s.id = s2c.student_id " +
            "join course c ON s2c.course_id = c.id " +
            "where c.course_name =:name",nativeQuery = true)
    List<Student> findStudentsByCoursesName(@Param("name") String name);

    @Query(value = "select s.* from student s " +
            "join student_course s2c on s.id = s2c.student_id " +
            "join course c ON s2c.course_id = c.id " +
            "where c.course_cost =:cost",nativeQuery = true)
    List<Student> findStudentByCoursesCost(@Param("cost") int cost);


    @Query(value = "SELECT * " +
            "FROM student s " +
            "WHERE s.id " +
            "          IN (SELECT s.id " +
            "              FROM student s " +
            "                       INNER JOIN student_course s_c on s.id = s_c.student_id " +
            "                       INNER JOIN Course c on s_c.course_id = c.id " +
            "              GROUP BY s.id " +
            "              HAVING max(course_cost) > :cost)",nativeQuery = true)
    List<Student> getStudentsWithExpensiveCourse(@Param("cost") int cost);

    @Query(value = "SELECT * FROM student WHERE id IN (:list)",nativeQuery = true)
    List<Student> findStudentsInList(@Param("list") List<Integer> list);
}
