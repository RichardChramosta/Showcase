package com.example.zerothweekproject.services;

import com.example.zerothweekproject.models.BookMark;
import com.example.zerothweekproject.models.DTOs.Type;
import com.example.zerothweekproject.models.MovieSummary;
import com.example.zerothweekproject.repositories.BookMarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookMarkServiceImpl implements BookMarkService{
    private final BookMarkRepo bookMarkRepo;

    public BookMarkServiceImpl(BookMarkRepo bookMarkRepo) {
        this.bookMarkRepo = bookMarkRepo;
    }

    @Override
    public List<BookMark> findReports() {
        return bookMarkRepo.findAll();
    }

    @Override
    public void deleteThisOne(Long id) {
        Optional<BookMark> report = bookMarkRepo.findById(id);
        bookMarkRepo.delete(report.get());
    }

    @Override
    public BookMark createBookMark(MovieSummary movieSummary) {
       String genre ="" ;
            //   movieSummary.getGenres().forEach(x-> genre = x.getName());
        for (Type t: movieSummary.getGenres()
             ) {
            genre = t.getName();
        }

        BookMark bookMark = new BookMark(movieSummary.getTitle(),genre);
        bookMarkRepo.save(bookMark);
        return bookMark;
    }
}
