package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> { }