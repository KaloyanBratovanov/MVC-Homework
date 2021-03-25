package com.softuni.web;

import com.softuni.model.view.HomeworkViewModel;
import com.softuni.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comments")
public class CommentsController {

    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;

    public CommentsController(HomeworkService homeworkService, ModelMapper modelMapper) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model){

        HomeworkViewModel homework = modelMapper
                .map(homeworkService.findHomeworkForScoring(), HomeworkViewModel.class);

        model.addAttribute("homework",homework);

        return "homework-check";
    }



}
