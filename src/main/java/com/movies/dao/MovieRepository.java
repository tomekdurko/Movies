package com.movies.dao;
import com.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
