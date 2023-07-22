package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controller;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.Answer;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;
    @PostMapping("/magic")
    public Answer getAnswer(@RequestBody String question) {
        List<Answer> answers = answerRepository.findAll();

        int randomIdx = ThreadLocalRandom.current().nextInt(answers.size());
        Answer answer = new Answer();
        answer.setId(randomIdx);
        answer.setQuestion(question);
        answer.setAnswer(answers.get(randomIdx).getAnswer());
        return answer;
    }
}
