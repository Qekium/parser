package ru.qekium.parser.loader;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Loader {
    private final RestTemplate restTemplate;

    public String load(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().isError()) {
            throw new ru.qekium.parser.loader.exception.LoadException("invalid status code");
        }
        return response.getBody();
    }
}
