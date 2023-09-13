package client;

import database.Database;
import database.Movie;
import database.user.User;
import java.util.ArrayList;

public class Session {
    private User currUser;
    private ArrayList<Movie> displayedMovies;
    private Database database;


    public Session() {
        // Proof that the Database Singleton implementation works.
        this.database = Database.getInstance();
        this.currUser = null;
        this.displayedMovies = null;
    }
}
