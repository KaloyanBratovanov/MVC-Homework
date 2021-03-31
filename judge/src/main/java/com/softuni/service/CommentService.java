package com.softuni.service;

import com.softuni.model.service.CommentServiceModel;

import java.util.List;
import java.util.Map;

public interface CommentService {

    void add(CommentServiceModel serviceModel, Long homeworkId);

    List<String> findTopUsers();

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
