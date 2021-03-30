package com.softuni.web;

import com.softuni.security.CurrentUser;
import com.softuni.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/")
    public String index (Model model){


        if (currentUser.isAnonymous()){
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllActiveExNames() );


        return "home";
    }
}
