package com.example.restcriteriaspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;

    @Column(name = "student_name")
    @Getter
    @Setter
    String studentName;

    @Setter
    @Getter
//    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    Set<Course> courses = new HashSet<>();

}

//@Table annotation is used to provide the details of the table that this entity will be mapped to.
//@Id annotation is used to define the primary key.
//@GeneratedValue annotation is used to define the primary key generation strategy.
// In the above case, we have declared the primary key to be an Auto Increment field.
//@Column annotation is used to define the properties of the column that will be mapped
// to the annotated field. You can define several properties like name, length, nullable, updateable etc.