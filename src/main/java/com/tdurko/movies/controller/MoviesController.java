package com.tdurko.movies.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.tdurko.movies.model.Movie;
import com.tdurko.movies.model.Views;
import com.tdurko.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private MovieService movieService;
    public MoviesController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @JsonView(Views.Public.class)
    @GetMapping
    public List<Movie> showMovies()
    {
        return movieService.getMovies();
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/{movieId}")
    public ResponseEntity showMovie(@PathVariable Long movieId)
    {
        ResponseEntity responseEntity;
        Optional<Movie> movie = movieService.getMovie(movieId);
        if (!movie.isPresent())
        {
            responseEntity= new ResponseEntity("No Movie found for ID " + movieId, HttpStatus.NOT_FOUND);
        }
        else
        {
            responseEntity= new ResponseEntity(movie, HttpStatus.OK);
        }
        return responseEntity;
    }

    @PostMapping
    ResponseEntity createMovie(@Valid @RequestBody Movie input, BindingResult bindingResult)
    {
        ResponseEntity responseEntity;
        if(bindingResult.hasErrors())
        {
            responseEntity=new ResponseEntity("Bad movie request", HttpStatus.BAD_REQUEST);
        }
        else
        {
            responseEntity=new ResponseEntity(input, HttpStatus.OK);
            movieService.addMovie(input);
        }

       return responseEntity;
    }


}
