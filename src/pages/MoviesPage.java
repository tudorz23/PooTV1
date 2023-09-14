package pages;

import database.Movie;
import utils.PageName;

import java.util.ArrayList;

public class MoviesPage extends Page{
    private ArrayList<Movie> movies;

    /* Constructor */
    public MoviesPage() {
        super();
        movies = new ArrayList<>();
        setType(PageName.MOVIES);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.AUTHENTICATED);
        getNextPages().add(PageName.SEE_DETAILS);
        getNextPages().add(PageName.LOGOUT);
    }

    /* Getters and Setters */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
