package ai.tyron.movies.repository;

import ai.tyron.movies.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Does the job of talking to the database and getting the data back
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>//So that it knows the ID and type
{
    Optional<Movie> findByImdbId(String imdbId);
}
