package com.itmo.reg.controller;

import com.itmo.reg.servise.CourseService;
import com.itmo.reg.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseListController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping("/course")
    public String courseLst(Model model) {
        model.addAttribute("allCourses", courseService.allCourses());
        return "course";
    }

    @PostMapping("/course")
    public String deleteCourse(
            @RequestParam(required = true, defaultValue = "") Long courseId,
            @RequestParam(required = true, defaultValue = "") String action,
            @RequestParam(required = true, defaultValue = "") String username,
            Model model) {

        if (action.equals("reg")) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            userService.setUserCourse(auth.getName(), courseId);
        }
        return "redirect:/course";
    }
}
