package com.movies.controller;

import com.movies.model.Movie;
import com.movies.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;


    @GetMapping
    public List<Movie> showMovies()
    {
        return movieService.getMovies();
    }

    @GetMapping("/{movieId}")
    public ResponseEntity showMovie(@PathVariable Long movieId)
    {
        Optional<Movie> movie = movieService.getMovie(movieId);
        if (movie == null) {
            return new ResponseEntity("No Movie found for ID " + movieId, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity createMovie(@RequestBody Movie input)
    {


        movieService.createMovie(input);
        return new ResponseEntity(input, HttpStatus.OK);
    }


}
