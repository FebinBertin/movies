package com.movieapp.controller;

import com.movieapp.model.Movie;
import com.movieapp.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieRepository movieRepo;

    public AdminController(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/admin_dashboard";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", movieRepo.findAll());
        return "admin/admin_movie_list";
    }

    @GetMapping("/add-movie")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "admin/admin_add_movie";
    }

    @PostMapping("/add-movie")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieRepo.save(movie);
        return "redirect:/admin/movies";
    }

    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable long id, Model model) {
        model.addAttribute("movie", movieRepo.findById(id).orElseThrow());
        return "admin/admin_edit_movie";
    }

    @PostMapping("/edit-movie/{id}")
    public String updateMovie(@ModelAttribute Movie movie) {
        movieRepo.save(movie);
        return "redirect:/admin/movies";
    }

    @GetMapping("/delete-movie/{id}")
    public String deleteMovie(@PathVariable long id) {
        movieRepo.deleteById(id);
        return "redirect:/admin/movies";
    }
}