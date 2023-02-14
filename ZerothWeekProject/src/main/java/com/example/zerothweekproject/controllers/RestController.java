package com.example.zerothweekproject.controllers;

import com.example.zerothweekproject.models.BookMark;
import com.example.zerothweekproject.models.Movie;
import com.example.zerothweekproject.models.MovieSummary;
import com.example.zerothweekproject.repositories.BookMarkRepo;
import com.example.zerothweekproject.services.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Value("${api.key}")
            private String apikey;
    BookMarkService bookMarkService;

    @Autowired
    private RestTemplate restTemplate;

    public RestController(BookMarkService bookMarkService) {
        this.bookMarkService = bookMarkService;
    }
    @RequestMapping( "/callit/{movieId}")
//    private Movie hetSomething(@PathVariable("movieId") String movieId){
//        String url = "https://api.themoviedb.org/3/movie/";
    public BookMark getMovieInfo(@PathVariable("movieId") String movieId) {
            MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apikey, MovieSummary.class);
         //   return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        BookMark bookMark = bookMarkService.createBookMark(movieSummary);
            return bookMark;

    }

//    @PostMapping("/complete/{id}")
//    public ResponseEntity DeleteReport(@PathVariable(required = false) Long id, @RequestBody(required = false) String secret){
//        if (secret == null || secret.equals("voala")) {
//            return ResponseEntity.status(404).body("");
//        }
//        bookMarkService.deleteThisOne(id);
//        return ResponseEntity.status(200).body("");
//    }

}
