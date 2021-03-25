package com.softuni.service.impl;

import com.softuni.model.service.HomeworkServiceModel;
import com.softuni.repository.HomeWorkRepository;
import com.softuni.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeWorkRepository homeWorkRepository;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeWorkRepository homeWorkRepository, ModelMapper modelMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public HomeworkServiceModel findHomeworkForScoring() {

        return homeWorkRepository.findTop1ByOrderByComments()
                .map(homework -> modelMapper
                .map(homework, HomeworkServiceModel.class)).orElse(null);
    }
}
