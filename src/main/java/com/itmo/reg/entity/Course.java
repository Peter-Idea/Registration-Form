package com.itmo.reg.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "t_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String coursename;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate coursedate;

    @NotNull
    private FormOfPayment courseformbay;


    @Transient
    @ManyToMany(mappedBy = "courses")
    private Set<User> users;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course(Long id, String courseName) {
        this.id = id;
        this.coursename = courseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public LocalDate getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(LocalDate coursedate) {
        this.coursedate = coursedate;
    }

    public FormOfPayment getCourseformbay() {
        return courseformbay;
    }

    public void setCourseformbay(FormOfPayment courseformbay) {
        this.courseformbay = courseformbay;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
