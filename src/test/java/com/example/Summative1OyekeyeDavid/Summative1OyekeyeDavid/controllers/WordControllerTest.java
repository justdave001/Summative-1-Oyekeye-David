package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controllers;

import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.controller.WordController;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models.Definition;
import com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.repository.DefinitionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DefinitionRepository definitionRepository;

    @Test
    void testGetDefinition() throws Exception{
        Definition definition = new Definition();
        definition.setId(0);
        definition.setWord("test");
        definition.setDefinition("test ans");

        List<Definition> definitionList = List.of(definition);

        when(definitionRepository.findAll()).thenReturn(definitionList);

        mockMvc.perform(MockMvcRequestBuilders.get("/word")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(definition)));
    }
}
