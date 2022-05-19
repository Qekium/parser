package ru.qekium.parser.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qekium.parser.model.User;

public interface ArticleRepository extends CrudRepository<User, Long> {

}
