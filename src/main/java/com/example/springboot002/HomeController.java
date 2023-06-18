package com.example.springboot002;

import com.example.springboot002.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final String title = "Test page";

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("users", userRepository.findAll());
                return "index";
    }
    @GetMapping("/home")
    public String home(Model model,
                        @RequestParam(value = "name",
                                required = false
                        ,defaultValue = "Guest") String name) {
        model.addAttribute("name", name);
        model.addAttribute("title", title);
        return "home";
    }
}
