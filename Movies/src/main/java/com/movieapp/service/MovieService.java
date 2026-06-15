package com.movieapp.service;

import java.util.List;
import com.movieapp.model.Movie;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie save(Movie movie);

    Movie findById(Long id);

    void deleteById(Long id);
}