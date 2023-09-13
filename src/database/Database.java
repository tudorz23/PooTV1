package database;

import database.user.User;

import java.util.ArrayList;

public class Database {
    private static Database instance = null;
    private ArrayList<User> users;
    private ArrayList<Movie> movies;

    private Database() {}

    /**
     * Applies the Singleton pattern to Database class.
     * @return the global instance of Database.
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    /* Getters and Setters */
    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
