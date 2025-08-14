package com.aeroparker.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String home() {
        return "redirect:/registration";
    }
    @GetMapping("/success")
    public String success() { return "success"; }

    @GetMapping("/registration")
    public String showForm(Model model) {
        // later we'll add: model.addAttribute("customer", new Customer());
        return "registration"; // looks for templates/registration.html
    }
}
