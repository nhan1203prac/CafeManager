package com.java.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.finalProject.model.users;
import com.java.finalProject.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class usersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        users user = new users();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/register";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords do not match");
            return "user/register";
        }
        userRepository.save(user);
        return "redirect:/users/login";
    }
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        users user = new users();
        model.addAttribute("user", user);
        return "user/login";
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") @Valid users user, BindingResult result, Model model,HttpSession session) {
        
        users existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null) {
            model.addAttribute("errorUser", "User not found");
            return "user/login";
        } else {
            if (existingUser.getPassword().equals(user.getPassword())) {
            	session.setAttribute("loggedInUser", existingUser);
                return "redirect:/home"; 
            } else {
                model.addAttribute("errorPassword", "Incorrect password");
                return "user/login";
            }
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
    
}
