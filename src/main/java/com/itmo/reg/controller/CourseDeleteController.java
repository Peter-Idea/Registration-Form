package com.itmo.reg.controller;

import com.itmo.reg.entity.Course;
import com.itmo.reg.entity.FormOfPayment;
import com.itmo.reg.servise.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class CourseDeleteController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courseDell")
    public String courseLst(Model model) {
        model.addAttribute("allCourses", courseService.allCourses());
        return "courseDell";

    }

    @PostMapping("/courseDell")
    public String deleteCourse(
            @RequestParam(required = true, defaultValue = "") Long courseId,
            @RequestParam(required = true, defaultValue = "") String action,
            @RequestParam(required = true, defaultValue = "") String coursename,
            @RequestParam(required = true, defaultValue = "") String coursedate,
            @RequestParam(required = true, defaultValue = "") FormOfPayment courseformbay,
            Model model) throws ParseException {
        if (action.equals("delete")) {
            courseService.deleteCourse(courseId);
        }

        if (action.equals("Добавить")) {
            Course newCourse = new Course();
            newCourse.setCoursename(coursename);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(coursedate, formatter);
            System.out.println();
            newCourse.setCoursedate(parsedDate);
            newCourse.setCourseformbay(courseformbay);
            courseService.saveCourse(newCourse);
        }
        return "redirect:/courseDell";
    }
}
