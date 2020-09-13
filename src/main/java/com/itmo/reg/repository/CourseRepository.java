package com.itmo.reg.repository;

import com.itmo.reg.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCoursename(String coursename);
}


