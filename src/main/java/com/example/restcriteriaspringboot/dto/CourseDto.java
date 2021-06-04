package com.example.restcriteriaspringboot.dto;

import com.example.restcriteriaspringboot.model.Course;
import com.example.restcriteriaspringboot.model.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CourseDto {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String courseName;

    @Getter
    @Setter
    int cost;

    @Getter
    @Setter
    Set<StudentDto> students = new HashSet<>();

    public List<CourseDto> getCourseDtoList(List<Course> courseSet) {
        List<CourseDto> courseDtoSet = new ArrayList<>();
        for (Course course : courseSet) {
            students = new HashSet<>();
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setCost(course.getCourseCost());
            for (Student student : course.getStudents()) {
                StudentDto studentDTO = new StudentDto();
                studentDTO.setId(student.getId());
                studentDTO.setStudentName(student.getStudentName());
                students.add(studentDTO);
            }
            courseDto.setStudents(students);
            courseDtoSet.add(courseDto);
        }
        return courseDtoSet;
    }
}


