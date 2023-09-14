package database;

import database.user.User;

import java.util.ArrayList;

public class Database {
    private static Database instance = null;
    private ArrayList<User> registeredUsers = new ArrayList<>();
    private ArrayList<Movie> availableMovies = new ArrayList<>();

    /* Private Constructor for Singleton pattern */
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

    /**
     * After every test, reset the database.
     */
    public void reset() {
        instance = null;
    }

    /* Getters and Setters */
    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }
    public void setRegisteredUsers(ArrayList<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
    public ArrayList<Movie> getAvailableMovies() {
        return availableMovies;
    }
    public void setAvailableMovies(ArrayList<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }
}
