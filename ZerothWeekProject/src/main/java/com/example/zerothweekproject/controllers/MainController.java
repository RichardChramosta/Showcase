package com.example.zerothweekproject.controllers;

import com.example.zerothweekproject.services.BookMarkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    BookMarkService bookMarkService;

    public MainController(BookMarkService bookMarkService) {
        this.bookMarkService = bookMarkService;
    }
    @GetMapping("/")
    public String ErrorReporter(Model model){
        model.addAttribute("movies",bookMarkService.findReports());
        return "main";
    }
}
