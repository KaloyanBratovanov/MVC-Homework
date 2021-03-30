package com.softuni.service.impl;

import com.softuni.model.entity.Homework;
import com.softuni.model.service.HomeworkServiceModel;
import com.softuni.repository.HomeworkRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.ExerciseService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;


    public HomeworkServiceImpl(HomeworkRepository homeWorkRepository, ModelMapper modelMapper, ExerciseService exerciseService, CurrentUser currentUser, UserService userService) {
        this.homeworkRepository = homeWorkRepository;
        this.modelMapper = modelMapper;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public HomeworkServiceModel findHomeworkForScoring() {

        return homeworkRepository.findTop1ByOrderByComments()
                .map(homework -> modelMapper
                .map(homework, HomeworkServiceModel.class)).orElse(null);
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {

        Homework homework = new Homework();
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homework.setExercise(exerciseService.findByName(exercise));
        homework.setAuthor(userService.findByUserId(currentUser.getId()));

        homeworkRepository.save(homework);

    }

    @Override
    public Homework findById(Long homeworkId) {
        return homeworkRepository.findById(homeworkId).orElse(null);
    }
}
