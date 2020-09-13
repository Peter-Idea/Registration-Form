package com.itmo.reg.servise;

import com.itmo.reg.entity.Course;
import com.itmo.reg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    public boolean saveCourse(Course course) {
        Course courseFromDB = courseRepository.findByCoursename(course.getCoursename());
        if (courseFromDB != null) {
            return false;
        }
        courseRepository.save(course);
        return true;
    }

    public boolean deleteCourse(Long courseId) {
        if (courseRepository.findById(courseId).isPresent()) {
            courseRepository.deleteById(courseId);
            return true;
        }
        return false;
    }

    public Course findCourseById(Long courseId) {
        Optional<Course> courseFromDb = courseRepository.findById(courseId);
        return courseFromDb.orElse(new Course());
    }

}
