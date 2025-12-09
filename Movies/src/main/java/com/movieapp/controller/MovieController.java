package com.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movieapp.repository.MovieRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRep;

    @GetMapping("/watch/{id}")
    public String watchMovie(@PathVariable long id, Model model) {
        model.addAttribute("movie", movieRep.findById(id).orElseThrow());
        return "user/movie_watch";
    }
}