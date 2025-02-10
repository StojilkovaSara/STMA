package com.example.task.controller;


import com.example.task.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final StudentService studentService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam(name = "firstName") String firstName,
                                  @RequestParam(name = "lastName") String lastName,
                                  @RequestParam(name = "username") String username,
                                  @RequestParam(name = "password") String password,
                                  Model model) {
        try {
            studentService.registerNewStudent(firstName, lastName, username, password);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "register";
        }
        return "redirect:/login";
    }
}