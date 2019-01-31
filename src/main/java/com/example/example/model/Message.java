package com.example.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("message")
    private String line;

    public Message(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
