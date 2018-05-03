package com.movies.service;

import com.movies.repository.MovieRepository;
import com.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repo;

    public MovieService() {}

    public Movie createMovie(Movie movie)

    {
        return repo.save(movie);
    }

    public Optional<Movie> getMovie(Long id)
    {
        return repo.findById(id);
    }
    public List<Movie> getMovies()
    {
        return repo.findAll();
    }
}
