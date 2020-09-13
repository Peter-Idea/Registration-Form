package com.itmo.reg.controller;

import com.itmo.reg.entity.Course;
import com.itmo.reg.servise.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseAddController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courseAdd")
    public String courseList(Model model) {
        model.addAttribute("newCourse", new Course());
        return "courseAdd";
    }


    @PostMapping("/courseAdd")
    public String addCourse(@ModelAttribute("newCourse") @Valid Course newCourse,
                            BindingResult bindingResult, Model model) {
        courseService.saveCourse(newCourse);
        return "redirect:/courseAdd";
    }
}
