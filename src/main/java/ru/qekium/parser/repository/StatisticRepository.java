package ru.qekium.parser.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qekium.parser.model.User;

public interface StatisticRepository extends CrudRepository<User, Long> {
}
