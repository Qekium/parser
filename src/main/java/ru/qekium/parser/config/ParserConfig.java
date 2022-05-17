package ru.qekium.parser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ParserConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
