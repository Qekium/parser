package ru.qekium.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.qekium.parser.loader.Loader;
import ru.qekium.parser.parser.HtmlParser;

@RequiredArgsConstructor
@SpringBootApplication
public class ParserRunner implements CommandLineRunner {


    private final Loader loader;

    private final HtmlParser parser;

    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";


    public static void main(String[] args) {
        SpringApplication.run(ParserRunner.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
