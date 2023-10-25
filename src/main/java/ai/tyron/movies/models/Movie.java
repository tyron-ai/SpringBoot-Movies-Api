package ai.tyron.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")

@Data //Takes care of our getters, setters and to string methods
@AllArgsConstructor //Creates constructor that takes in all the private fields as arguments
@NoArgsConstructor //Constructor taking no parameters
public class Movie {


    @Id
    private ObjectId objId;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;//Link to movie image poster
    private List<String> genres;//Since movie can be part of multiple genres
    private List<String> backdrops; //Used in frontEnd;

    @DocumentReference
    private List<Review> reviewIds; //Embeded relationship. Good for modelling 1 to Many relationship

}
