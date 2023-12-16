package com.example.maraton5.controller;

import com.example.maraton5.dto.answer.AnswerSaveRequest;
import com.example.maraton5.entity.Answer;
import com.example.maraton5.entity.Question;
import com.example.maraton5.repository.AnswerRepository;
import com.example.maraton5.service.AnswerService;
import com.example.maraton5.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    private final AnswerRepository answerRepository;

    public AnswerController(AnswerService answerService, AnswerRepository answerRepository) {
        this.answerService = answerService;

        this.answerRepository = answerRepository;
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId( Long questionId) {
        List<Answer> answers = answerService.getAnswersByQuestionId(questionId);
        return ResponseEntity.ok(answers);
    }

//    @PostMapping("/save")
//    public ResponseEntity<List<Answer>> saveAnswer (AnswerSaveRequest request){
//        Question question = questionService.findById(request.getQuestionById());
//        Answer answer = answerService.saveDto(request);
//        question.getAnswers().add(answer);
//    }


//    @PostMapping("/save")
//    public ResponseEntity<List<Answer>> saveAnswer() {
//        Answer sampleAnswer = new Answer();
//        sampleAnswer.setContent("Sample Answer");
//        List<Question> questions = List.of(
//                createQuestion("İstanbul"),
//                createQuestion("İstanbul"),
//                createQuestion("İstanbul")
//        );
//        sampleAnswer.setQuestion(questions);
//        Answer savedAnswer = answerRepository.save(sampleAnswer);
//        return new ResponseEntity<>(sampleAnswer, HttpStatus.CREATED);
//    }
//
//    private Answer createQuestion(String content) {
//        Question question = new Question();
//        question.setContent(content);
//        return question;
//    }

    @PostMapping("/save-answer")
    public ResponseEntity<Answer> saveAnswer() {
        Answer newAnswer = new Answer();
        newAnswer.setContent("Sample Answer");

        List<Answer> answers = List.of(
                createAnswer("Pendik Hangi İle Bağlıdır?"),
                createAnswer("Dünyanın En Güzel Yeri Neresi?"),
                createAnswer("Dünyanın Kalbi Neresidir?")
        );

        Answer sampleAnswer = new Answer();

        Answer savedAnswer = answerRepository.save(sampleAnswer);

        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }

    private Answer createAnswer(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        return answer;
    }




}
