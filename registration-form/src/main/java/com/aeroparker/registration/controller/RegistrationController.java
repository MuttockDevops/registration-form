package com.aeroparker.registration.controller;

import com.aeroparker.registration.model.Customer;
import com.aeroparker.registration.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping({"/", "/registration"})
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (repo.existsByEmailAddressIgnoreCase(customer.getEmailAddress())) {
            model.addAttribute("error", "Email already in use");
            return "registration";
        }
        customer.setRegistered(LocalDateTime.now());
        repo.save(customer);
        model.addAttribute("firstName", customer.getFirstName());
        return "success";
    }
}