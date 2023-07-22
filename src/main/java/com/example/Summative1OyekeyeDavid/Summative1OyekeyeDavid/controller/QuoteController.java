package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controller;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.Service.QuoteService;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.QUOTE;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.QuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    @Autowired
    QuoteService quoteService;
    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteController.class);

    @GetMapping("/quote")
    @ResponseBody
    public QUOTE quoteCount() {
        List<QUOTE> quotes = quoteService.getQuotes();
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
       return quotes.get(randomIndex);
    }
}
