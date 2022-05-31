package ru.qekium.parser.service.concurrent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.qekium.parser.loader.Loader;
import ru.qekium.parser.model.Article;
import ru.qekium.parser.parser.HtmlParser;
import ru.qekium.parser.service.ApplicationStorage;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomTaskExecutor {
    private final Loader loader;
    private final HtmlParser parser;
    private final ApplicationStorage storage;

    public List<Article> execute(String url) {
        try {
            log.info("start loading {}", url);
            String response = loader.load(url);
            log.info("start parsing {}");
            return parser.parse(response);
        } catch (Exception e) {
            log.error("execution error", e);
            return List.of();

        }
    }
}


