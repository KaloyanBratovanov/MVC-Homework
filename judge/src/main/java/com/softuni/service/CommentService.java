package com.softuni.service;

import com.softuni.model.service.CommentServiceModel;

public interface CommentService {

    void add(CommentServiceModel serviceModel, Long homeworkId);

}
