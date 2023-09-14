package client;

import database.Database;
import database.Movie;
import database.pages.Page;
import database.pages.PageFactory;
import database.user.User;
import utils.PageName;

import java.util.ArrayList;

public class Session {
    private Database database;
    private User currUser;
    private Page currPage;
    private ArrayList<Movie> currMovieList;
    private final PageFactory pageFactory;

    public Session() {
        // Proof that the Database Singleton implementation works.
        database = Database.getInstance();
        currUser = null;
        pageFactory = new PageFactory();
        currPage = pageFactory.createPage(PageName.UNAUTHENTICATED);
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
