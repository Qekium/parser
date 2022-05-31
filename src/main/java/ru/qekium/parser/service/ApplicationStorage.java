package ru.qekium.parser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.qekium.parser.repository.ArticleRepository;
import ru.qekium.parser.repository.CategoryRepository;
import ru.qekium.parser.repository.StatisticRepository;
import ru.qekium.parser.repository.UserRepository;

@Service
@RequiredArgsConstructor

public class ApplicationStorage {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StatisticRepository statisticRepository;

    //homework


}
