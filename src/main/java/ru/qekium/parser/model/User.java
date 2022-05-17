package ru.qekium.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
    private final String username;
    private final String url;
}

