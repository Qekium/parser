package ru.qekium.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.qekium.parser.model.Article;
import ru.qekium.parser.model.User;

public interface ArticleRepository extends JpaRepository<Article, Long> { // merge with the home project version

}
