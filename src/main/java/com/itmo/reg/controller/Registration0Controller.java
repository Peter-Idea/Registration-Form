package com.itmo.reg.controller;


import com.itmo.reg.entity.User;
import com.itmo.reg.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Registration0Controller {


    @Autowired
    private UserService userService;

    @GetMapping("/registration0")
    public String registration0(Model model) {
        model.addAttribute("userForm"
                , userService.loadUserByUsername(
                        SecurityContextHolder.getContext()
                                .getAuthentication().getName()));
        return "registration0";
    }

    @PostMapping("/registration0")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
                          BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration0";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userForm.setUsername(auth.getName());
        userService.resaveUser(userForm);
        return "redirect:/";
    }

}
