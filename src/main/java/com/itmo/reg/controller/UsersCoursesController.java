package com.itmo.reg.controller;

import com.itmo.reg.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersCoursesController {

    @Autowired
    private UserService userService;

    @GetMapping("/userCourse")
    public String coursesList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("usersCourses", userService.getUserCourses(auth.getName()));
        return "userCourse";
    }

}
