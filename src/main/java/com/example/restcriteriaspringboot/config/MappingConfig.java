package com.example.restcriteriaspringboot.config;

import com.example.restcriteriaspringboot.dto.CourseDto;
import com.example.restcriteriaspringboot.dto.StudentDto;
import com.example.restcriteriaspringboot.model.Course;
import com.example.restcriteriaspringboot.model.Student;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    public BeanMappingBuilder beanMappingBuilder(){
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Student.class, StudentDto.class);
                mapping(Course.class, CourseDto.class)
                        .fields("courseCost","cost");
            }
        };
    }
    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }

}
