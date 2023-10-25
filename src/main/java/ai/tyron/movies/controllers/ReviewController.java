package ai.tyron.movies.controllers;

import ai.tyron.movies.models.Review;
import ai.tyron.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews    ")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    //What we get in the request body we would like to convert it to a map of key string and value string
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload)
    {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }


}
