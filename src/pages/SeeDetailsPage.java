package pages;

import database.Movie;
import utils.PageType;

public class SeeDetailsPage extends Page {
    private Movie movie;

    /* Constructor */
    public SeeDetailsPage() {
        super();
        setType(PageType.SEE_DETAILS);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.AUTHENTICATED);
        getNextPages().add(PageType.MOVIES);
        getNextPages().add(PageType.UPGRADES);
        getNextPages().add(PageType.UNAUTHENTICATED);
    }

    /* Getters and Setters */
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
