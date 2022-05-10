package ru.qekium.parser.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.qekium.parser.ParserRunner;
import ru.qekium.parser.model.Article;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
    public List<Article> parse(String html) {
        Document document = Jsoup.parse(html);
        Elements articleElements = document.select(".tm-articles-list__item");
        List<Article> articles = new ArrayList<>();
        for (Element articleElement : articleElements) {
            System.out.println(articleElement.text());
            String username = articleElement.select(".tm-user-info__username").text();
            Elements titleEl = articleElement.select(".tm-article-snippet__title-link");
            String title = titleEl.select("span").text();
            String url = ParserRunner.HABR_DOMAIN + titleEl.attr("href");
            String description = articleElement.select(".article-formatted-body p").text();
            articles.add (new Article(username, title, description, url));
        }
        return null;


    }
}
