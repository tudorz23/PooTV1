package client;

import database.Database;
import database.Movie;
import database.pages.Page;
import database.user.User;
import java.util.ArrayList;

public class Session {
    private Database database;
    private User currUser;
    private Page currPage;
    private ArrayList<Movie> currMovieList;

    public Session() {
        // Proof that the Database Singleton implementation works.
        this.database = Database.getInstance();
        this.currUser = null;
        // TODO factory page
        // this.currPage = ;
    }

    /* Getters and Setters */
    public User getCurrUser() {
        return currUser;
    }
    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }
    public Page getCurrPage() {
        return currPage;
    }
    public void setCurrPage(Page currPage) {
        this.currPage = currPage;
    }
    public ArrayList<Movie> getCurrMovieList() {
        return currMovieList;
    }
    public void setCurrMovieList(ArrayList<Movie> currMovieList) {
        this.currMovieList = currMovieList;
    }
}
