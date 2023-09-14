package client;

import database.Database;
import database.Movie;
import pages.Page;
import pages.PageFactory;
import database.User;
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
        currMovieList = new ArrayList<>();
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
    public PageFactory getPageFactory() {
        return pageFactory;
    }
}
