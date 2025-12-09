package com.movieapp.controller;

import com.movieapp.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final MovieRepository movieRepo;

    public UserController(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("/movies")
    public String movieList(Model model) {
        model.addAttribute("movies", movieRepo.findAll());
        return "user/movie_list";   // User movie_list.html (no edit/delete)
    }

    @GetMapping("/watch/{id}")
    public String watchMovie(@PathVariable long id, Model model) {
        model.addAttribute("movie", movieRepo.findById(id).orElseThrow());
        return "user/movie_watch";
    }
}