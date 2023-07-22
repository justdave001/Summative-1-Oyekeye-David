package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.Service;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.QUOTE;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    public List<QUOTE> getQuotes() {
       return (quoteRepository.findAll());
    }
}
