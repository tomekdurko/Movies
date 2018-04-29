package movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
public class MoviesController {

    @Autowired
    private MovieRepository repo;


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    Collection<Movie> showMovies()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    Optional<Movie> showMovie(@PathVariable Long movieId)
    {
        return repo.findById(movieId);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    ResponseEntity create(@RequestBody Movie input)
    {
        Movie result = repo.save(new Movie(input));

        URI location=URI.create("/movies/" + result.getId());


        repo.save(input);
        return ResponseEntity.created(location).build();
    }


}
