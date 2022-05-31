package ru.qekium.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.qekium.parser.model.Article;
import ru.qekium.parser.repository.CategoryRepository;
import ru.qekium.parser.service.concurrent.CustomTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@SpringBootApplication
public class ParserRunner implements CommandLineRunner {


    private final CustomTaskExecutor taskExecutor;
    private final CategoryRepository repository;

    private ExecutorService executorService = Executors.newFixedThreadPool(6);

//    public static final String HABR_DOMAIN = "https://habr.com";
//    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";


    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(finalI);
//                    System.out.println(finalI);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//        }

        SpringApplication.run(ParserRunner.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        List<String> urls = List.of(
                "https://habr.com/ru/hub/read",
                "https://habr.com/ru/hub/pm",
                "https://habr.com/ru/hub/python",
                "https://habr.com/ru/hub/career",
                "https://habr.com/ru/hub/lib",
                "https://habr.com/ru/hub/ui"
        );
        List<Callable<List<Article>>> tasks = urls
                .stream()
                .map(url -> (Callable<List<Article>>) () -> taskExecutor.execute(url))
                .collect(Collectors.toList());
        List<Article> result = new ArrayList<>();
        for (Future<List<Article>> future : executorService.invokeAll(tasks)) {
            try {
                result.addAll(future.get());
            }
            catch (ExecutionException e) {
                System.out.println("task execution error");
            }
        }
        System.out.println();
    }
