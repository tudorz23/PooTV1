package pages;

import database.Movie;
import utils.PageType;

import java.util.ArrayList;

public class MoviesPage extends Page{
    private ArrayList<Movie> movies;

    /* Constructor */
    public MoviesPage() {
        super();
        movies = new ArrayList<>();
        setType(PageType.MOVIES);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.AUTHENTICATED);
        getNextPages().add(PageType.SEE_DETAILS);
        getNextPages().add(PageType.UNAUTHENTICATED);
    }

    /* Getters and Setters */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
