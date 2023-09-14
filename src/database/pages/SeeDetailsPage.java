package database.pages;

import database.Movie;
import utils.PageName;

public class SeeDetailsPage extends Page {
    private Movie movie;

    /* Constructor */
    public SeeDetailsPage() {
        super();
        setType(PageName.SEE_DETAILS);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.AUTHENTICATED);
        getNextPages().add(PageName.MOVIES);
        getNextPages().add(PageName.UPGRADES);
        getNextPages().add(PageName.LOGOUT);
    }

    /* Getters and Setters */
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
