package com.example.Summative1OyekeyeDavid.Summative1OyekeyeDavid.models;

import jakarta.persistence.*;

@Entity
@Table(name = "QUOTE")
public class QUOTE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
    private String quote;
}
