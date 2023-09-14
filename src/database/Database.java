package database;

import database.user.User;

import java.util.ArrayList;

public class Database {
    private static Database instance = null;
    private ArrayList<User> registeredUsers;
    private ArrayList<Movie> availableMovies;

    /* Private Constructor for Singleton pattern */
    private Database() {
        registeredUsers = new ArrayList<>();
        availableMovies = new ArrayList<>();
    }

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
