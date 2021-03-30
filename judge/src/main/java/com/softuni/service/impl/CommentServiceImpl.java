package com.softuni.service.impl;

import com.softuni.model.entity.Comment;
import com.softuni.model.service.CommentServiceModel;
import com.softuni.repository.CommentRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
    }


    @Override
    public void add(CommentServiceModel serviceModel, Long homeworkId) {

        Comment comment = modelMapper.map(serviceModel, Comment.class);

        comment.setAuthor(userService.findByUserId(currentUser.getId()));
        comment.setHomework(homeworkService.findById(homeworkId));

        commentRepository.save(comment);

    }
}
