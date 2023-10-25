package ai.tyron.movies.services;

import ai.tyron.movies.models.Movie;
import ai.tyron.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies()
    {
        return movieRepository.findAll(); //Find all is already defined in the mongo repository class
    }

    public Optional<Movie> getMovieById(String imdbId)
    {
        return movieRepository.findByImdbId(imdbId);
    }
}
