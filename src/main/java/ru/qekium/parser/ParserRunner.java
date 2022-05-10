package ru.qekium.parser;

import ru.qekium.parser.loader.Loader;
import ru.qekium.parser.parser.HtmlParser;

public class ParserRunner {
    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";

    public static void main(String[] args) {
        Loader loader = new Loader();
        String response = loader.load(HABR_URL);
        HtmlParser parser = new HtmlParser();
        parser.parse(response);

    }
}
