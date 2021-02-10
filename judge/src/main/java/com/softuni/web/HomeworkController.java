package com.softuni.web;

import com.softuni.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    private final ExerciseService exerciseService;

    public HomeworkController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("exNames", exerciseService.findAllExNames());
        return "homework-add";
    }
}
