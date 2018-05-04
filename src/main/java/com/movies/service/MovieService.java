package com.movies.service;

import com.movies.repository.MovieRepository;
import com.movies.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

   public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository=movieRepository;
    }

    public Movie addMovie(Movie movie)

    {
        return movieRepository.save(movie);
    }

    public Optional<Movie> getMovie(long id)
    {
        return movieRepository.findById(id);
    }

    public List<Movie> getMovies()
    {
        return movieRepository.findAll();
    }
}
