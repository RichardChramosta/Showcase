package com.example.zerothweekproject.services;

import com.example.zerothweekproject.models.BookMark;
import com.example.zerothweekproject.models.MovieSummary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookMarkService {
    List<BookMark> findReports();
    void deleteThisOne(Long id);

    BookMark createBookMark(MovieSummary movieSummary);
}
