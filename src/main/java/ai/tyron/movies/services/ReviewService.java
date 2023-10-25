package ai.tyron.movies.services;

import ai.tyron.movies.models.Movie;
import ai.tyron.movies.models.Review;
import ai.tyron.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //Used to talk to the DB requiring a complex operation that cannot be implemented using a repository
    //Basically used to form a dynamic query and do the job inside a dynamic database

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody,String imdbId)
    {
        //Need to first find movie by imdbId
        Review review=reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
