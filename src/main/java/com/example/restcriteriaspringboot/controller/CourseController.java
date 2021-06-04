package com.example.restcriteriaspringboot.controller;

import com.example.restcriteriaspringboot.dto.CourseDto;
import com.example.restcriteriaspringboot.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("course")
    public List<CourseDto> getCourses() {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseRepository.findAll());
    }

    @GetMapping("/courses/find")
    public List<CourseDto> getCoursesByStudentName(@RequestParam(value = "name") String name) {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseRepository.findAllByStudentName(name));
    }

    @GetMapping("/expensive_courses")
    public List<CourseDto> getExpensiveCourse() {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseRepository.findExpensiveCourse());
    }

}
