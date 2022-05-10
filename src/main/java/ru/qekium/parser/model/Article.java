package ru.qekium.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    // private User user [username, url]
    private String userName;
    // private LocalDate publishDate;
    // private List<Categories> categories [name, url]
    private String title;
    private String description;
    private String url;
    // private Statistics statistics [rep, view, bookmarks, comments]

}
