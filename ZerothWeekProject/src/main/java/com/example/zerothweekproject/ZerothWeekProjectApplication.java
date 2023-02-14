package com.example.zerothweekproject;

import com.example.zerothweekproject.models.BookMark;
import com.example.zerothweekproject.repositories.BookMarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZerothWeekProjectApplication implements CommandLineRunner {

    BookMarkRepo bookMarkRepo;
    @Autowired
    public ZerothWeekProjectApplication(BookMarkRepo bookMarkRepo) {
        this.bookMarkRepo = bookMarkRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZerothWeekProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<BookMark> marks = new ArrayList<>(List.of(
                new BookMark("300 Battle of Thermopylae", "action"),
                new BookMark("Zombieland", "comedy")
        ));
        bookMarkRepo.saveAll(marks);
    }
    @Bean
    public RestTemplate getRestTemplate(){
          return new RestTemplate();}
}
