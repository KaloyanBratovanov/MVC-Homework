package com.softuni.web;

import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.ExerciseService;
import com.softuni.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final UserService userService;
    private final CommentService commentService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, UserService userService, CommentService commentService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String index (Model model){


        if (currentUser.isAnonymous()){
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllActiveExNames() );

        model.addAttribute("students", commentService.findTopUsers());

        model.addAttribute("avg", commentService.findAvgScore());

        model.addAttribute("usersCount", userService.findAllUsernames().size());

        model.addAttribute("scoreMap", commentService.findScoreMap());


        return "home";
    }
}
