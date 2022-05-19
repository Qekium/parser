package ru.qekium.parser.model;

import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Table(name = "articles")
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(generator = "articles_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "article_gen", sequenceName = "articles_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
//    private User user;
    private String userName;
    private ZonedDateTime publishDate;
    @ManyToMany
    @JoinTable(
            name = "articles_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    private String title;
    private String description;
    private String url;
//    private Statistic statistics;


    public Article(User user, String userName, ZonedDateTime publishDate, String title, String description, String url) {
//        this.user = user;
        this.userName = userName;
        this.publishDate = publishDate;
//        this.categories = categories;
        this.title = title;
        this.description = description;
        this.url = url;
//        this.statistics = statistics;
    }
}
