package com.tdurko.movies.repository;
import com.tdurko.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
