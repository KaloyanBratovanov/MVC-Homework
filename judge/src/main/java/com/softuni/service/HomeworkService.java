package com.softuni.service;

import com.softuni.model.service.HomeworkServiceModel;

public interface HomeworkService {

    HomeworkServiceModel findHomeworkForScoring();

    void addHomework(String exercise, String gitAddress);
}
