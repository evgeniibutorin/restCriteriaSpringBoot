package com.example.restcriteriaspringboot.controller;

import com.example.restcriteriaspringboot.dto.StudentDto;
import com.example.restcriteriaspringboot.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("student")
    public List<StudentDto> getStudent() {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentRepository.findAll());
    }

    @GetMapping("student/find")
    public List<StudentDto> getStudentsByCourse(@RequestParam(value = "name") String name) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentRepository.findStudentsByCoursesName(name));
    }


    @GetMapping("student/cost")
    public List<StudentDto> getStudentByCoursesCost(@RequestParam(value = "cost") String cost) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentRepository.findStudentByCoursesCost(Integer.parseInt(cost)));
    }

    @GetMapping("/student/cost/more")
    public List<StudentDto> getStudentWithExpensiveCourse(@RequestParam(value = "cost") String cost) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentRepository.getStudentsWithExpensiveCourse(Integer.parseInt(cost)));
    }

    @GetMapping("/students/from/list")
    public List<StudentDto> getStudentInList() {
        StudentDto studentDto = new StudentDto();
        List<Integer> studentIdes = new ArrayList<>();
        for (int i = 0; i < 1003; i++) {
            studentIdes.add(i);
        }
        return studentDto.getStudentDtoList(studentRepository.findStudentsInList(studentIdes));
    }

}