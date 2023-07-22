package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controllers;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.Service.QuoteService;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controller.QuoteController;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.QUOTE;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.QuoteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private QuoteService quoteService;

    @Test
    void testGetQuote() throws Exception {
        QUOTE quote = new QUOTE();
        quote.setId(1);
        quote.setAuthor("david");
        quote.setQuote("certified");

        List<QUOTE> quoteList = List.of(quote);
        when(quoteService.getQuotes()).thenReturn(quoteList);

        mockMvc.perform(MockMvcRequestBuilders.get("/quote")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(quote)));
    }
}
