package com.example.maraton5.service;

import com.example.maraton5.entity.Answer;
import com.example.maraton5.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

}
