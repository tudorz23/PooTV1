package client;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.Database;
import database.Movie;
import database.user.Credentials;
import database.user.User;
import fileInput.Input;
import fileInput.MovieInput;
import fileInput.UserInput;
import fileOutput.PrinterJson;

import java.util.ArrayList;

public class UserInteraction {
    private Session session;
    private final Input input;
    private ObjectNode output;
    private Database database;

    /* Constructor */
    public UserInteraction(Input input, ObjectNode output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Instantiates the global Singleton Database and
     * populates it with data taken from the input.
     */
    public void prepareDatabase() {
        // First call of Database.getInstance().
        this.database = Database.getInstance();

        // Populate database with registered users.
        for (UserInput userInput : input.getUsers()) {
            Credentials credentials = new Credentials(userInput.getCredentials());
            User user = new User(credentials);
            database.getRegisteredUsers().add(user);
        }

        // Populate database with available movies.
        for (MovieInput movieInput : input.getMovies()) {
            // Use Builder pattern
            Movie movie = new Movie(movieInput);
            database.getAvailableMovies().add(movie);
        }
    }

    public void printDatabase() {
        ArrayNode registeredUsers = PrinterJson.getUserArrayNode(database.getRegisteredUsers());
        output.set("users", registeredUsers);

        ArrayNode availableMovies = PrinterJson.getMovieArrayNode(database.getAvailableMovies());
        output.set("movies", availableMovies);
    }

    /**
     * Iterates through the actions from the input.
     */
    public void parseActions() {

    }

    public void initSession() {
        session = new Session();

    }
}
