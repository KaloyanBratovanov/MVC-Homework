package com.softuni.service;

import com.softuni.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {

    void addEx(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames();

}
