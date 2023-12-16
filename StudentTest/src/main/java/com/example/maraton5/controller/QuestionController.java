package com.example.maraton5.controller;


import com.example.maraton5.entity.Answer;
import com.example.maraton5.entity.Question;
import com.example.maraton5.repository.QuestionRepository;
import com.example.maraton5.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService,QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/getAll")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(Long id) {
        Question question = questionService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }


    @PostMapping ("/save")
    public ResponseEntity<Question> saveQuestion() {
        Question sampleQuestion = new Question();
        sampleQuestion.setContent("Sample Question");
        List<Answer> answers = List.of(
                createAnswer("Pendik Hangi ile Bağlıdır ?"),
                createAnswer("Dünyanın En güzel Yeri Neresi ?"),
                createAnswer("Dünyanın Kalbi Neresidir ?")
        );
        sampleQuestion.setAnswers(answers);
        Question savedQuestion = questionRepository.save(sampleQuestion);
        return new ResponseEntity<>(sampleQuestion, HttpStatus.CREATED);
    }

    private Answer createAnswer(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        return answer;
    }



}
