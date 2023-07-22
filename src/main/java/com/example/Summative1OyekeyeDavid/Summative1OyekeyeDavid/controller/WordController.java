package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controller;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.Definition;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.DefinitionRepository;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class WordController {
    @Autowired
    private DefinitionRepository definitionRepository;
    @GetMapping("/word")
    public Definition getDefinition() {
        List<Definition> words = definitionRepository.findAll();

        int randomIndex = ThreadLocalRandom.current().nextInt(words.size());
        return words.get(randomIndex);
    }
}
