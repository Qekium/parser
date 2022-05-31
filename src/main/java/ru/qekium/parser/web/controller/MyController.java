package ru.qekium.parser.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.qekium.parser.model.Article;
import ru.qekium.parser.service.util.ArticleService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/article") //localhost:8000
@RequiredArgsConstructor
public class MyController {
    private final ArticleService articleService;
    private final ObjectMapper objectMapper;

    @GetMapping("/new")
    public List<Article> getNewArticle() {
        return articleService.getNew();
    }

    @GetMapping("/user?userId={userId}")
    public List<Article> getArticlesByUser(@RequestParam Long userId) {
        return List.of();
    }

    @PostMapping("/date")
    public List<Article> getArticlesByDate(@RequestBody Instant date) {
        return List.of();
    }

    @GetMapping(value = "/new/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getNewArticlesAsFile() {
        List<Article> articleList = articleService.getNew();

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            byte[] bytes = objectMapper.writeValueAsBytes(articleList);
            outputStream.writeBytes(bytes);
            return outputStream.toByteArray();
        } catch (IOException e){
            return new byte[0];
        }
    }

    @PostMapping("/write/file")
    public void writeArticles(@RequestBody byte[] bytes) throws IOException{
        String s = new String(bytes, StandardCharsets.UTF_8);
        String decode = URLDecoder.decode(s, StandardCharsets.UTF_8);
        List<Article>articles = objectMapper.readValue(decode, new TypeReference<>(){});
        for (Article article: articles){
            System.out.println(article.getTitle());
        }
    }

}
