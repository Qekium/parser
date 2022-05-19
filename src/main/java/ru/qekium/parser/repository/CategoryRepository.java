package ru.qekium.parser.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qekium.parser.model.User;

public interface CategoryRepository extends CrudRepository<User, Long> {
}
