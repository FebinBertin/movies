package com.movieapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movieapp.model.Movie;
import com.movieapp.repository.MovieRepository;
import com.movieapp.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}