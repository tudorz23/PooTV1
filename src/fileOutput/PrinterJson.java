package fileOutput;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.Movie;
import database.user.Credentials;
import database.user.User;

import java.util.ArrayList;

public class PrinterJson {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converts an ArrayList of users to an ArrayNode for JSON printing.
     */
    public static ArrayNode getUserArrayNode(ArrayList<User> users) {
        ArrayNode userArrayNode = mapper.createArrayNode();

        for (User user : users) {
            ObjectNode userNode = getUserNode(user);
            userArrayNode.add(userNode);
        }

        return userArrayNode;
    }

    /**
     * Converts a user object to an ObjectNode for JSON printing.
     */
    public static ObjectNode getUserNode(User user) {
        ObjectNode userNode = mapper.createObjectNode();

        {
            ObjectNode credentialsNode = mapper.createObjectNode();
            Credentials credentials = user.getCredentials();

            credentialsNode.put("name", credentials.getName());
            credentialsNode.put("password", credentials.getPassword());
            credentialsNode.put("accountType", credentials.getAccountType());
            credentialsNode.put("country", credentials.getCountry());
            credentialsNode.put("balance", credentials.getBalance());

            userNode.set("credentials", credentialsNode);
        }

        userNode.put("tokensCount", user.getTokensCount());
        userNode.put("numFreePremiumMovies", user.getNumFreePremiumMovies());

        ArrayNode purchasedMoviesArrayNode = getMovieArrayNode(user.getPurchasedMovies());
        userNode.set("purchasedMovies", purchasedMoviesArrayNode);

        ArrayNode watchedMoviesArrayNode = getMovieArrayNode(user.getWatchedMovies());
        userNode.set("watchedMovies", watchedMoviesArrayNode);

        ArrayNode likedMoviesArrayNode = getMovieArrayNode(user.getLikedMovies());
        userNode.set("likedMovies", likedMoviesArrayNode);

        ArrayNode ratedMoviesArrayNode = getMovieArrayNode(user.getRatedMovies());
        userNode.set("ratedMovies", ratedMoviesArrayNode);

        return userNode;
    }

    /**
     * Converts an ArrayList of movies to an ArrayNode for JSON printing.
     */
    public static ArrayNode getMovieArrayNode(ArrayList<Movie> movies) {
        ArrayNode movieArrayNode = mapper.createArrayNode();

        for (Movie movie : movies) {
            ObjectNode movieNode = getMovieNode(movie);
            movieArrayNode.add(movieNode);
        }

        return movieArrayNode;
    }

    /**
     * Converts a movie object to an ObjectNode for JSON printing.
     */
    public static ObjectNode getMovieNode(Movie movie) {
        ObjectNode movieNode = mapper.createObjectNode();

        movieNode.put("name", movie.getName());
        movieNode.put("year", movie.getYear());
        movieNode.put("duration", movie.getDuration());

        // Add the genres as an ArrayNode.
        ArrayNode genresNode = mapper.createArrayNode();
        for (String genre : movie.getGenres()) {
            genresNode.add(genre);
        }
        movieNode.set("genres", genresNode);

        // Add the actors as an ArrayNode.
        ArrayNode actorsNode = mapper.createArrayNode();
        for (String actor : movie.getActors()) {
            actorsNode.add(actor);
        }
        movieNode.set("actors", actorsNode);

        // Add the banned countries as an ArrayNode
        ArrayNode countriesBannedNode = mapper.createArrayNode();
        for (String countryBanned : movie.getCountriesBanned()) {
            countriesBannedNode.add(countryBanned);
        }
        movieNode.set("countriesBanned", countriesBannedNode);

        movieNode.put("numLikes", movie.getNumLikes());
        movieNode.put("rating", movie.getRating());
        movieNode.put("numRatings", movie.getNumRatings());

        return movieNode;
    }
}
