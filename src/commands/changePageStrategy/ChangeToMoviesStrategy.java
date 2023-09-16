package commands.changePageStrategy;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import database.Database;
import database.Movie;
import database.User;
import fileOutput.ErrorPrinter;
import fileOutput.SuccessPrinter;
import pages.MoviesPage;
import utils.PageType;
import pages.PageFactory;

public class ChangeToMoviesStrategy implements IChangePageStrategy {
    private Session session;
    private ArrayNode output;

    /* Constructor */
    public ChangeToMoviesStrategy(Session session, ArrayNode output) {
        this.session = session;
        this.output = output;
    }

    @Override
    public void changePage() {
        if (!testValidity()) {
            return;
        }

        PageFactory pageFactory = new PageFactory();
        session.setCurrPage(pageFactory.createPage(PageType.MOVIES));
        copyMovies();

        SuccessPrinter successPrinter = new SuccessPrinter();
        successPrinter.printMovies(session.getCurrMovieList(),
                                    session.getCurrUser(), output);
    }

    /**
     * Checks if the changePage command is valid.
     * @return true if it is valid, false otherwise.
     */
    private boolean testValidity() {
        if (!session.getCurrPage().getNextPages().contains(PageType.MOVIES)) {
            ErrorPrinter errorPrinter = new ErrorPrinter();
            errorPrinter.printError(output);
            return false;
        }
        return true;
    }

    /**
     * Selects the movies from the Database that are not banned in current user's country
     * and copies them to the current page and to the session's list.
     */
    private void copyMovies() {
        User user = session.getCurrUser();

        for (Movie movie : Database.getInstance().getAvailableMovies()) {
            if (!movie.getCountriesBanned().contains(user.getCredentials().getCountry())) {
                // Add to current page's Movie list.
                ((MoviesPage) session.getCurrPage()).getMovies().add(movie);
            }
        }

        // Copy the movie list to the session's movie list.
        session.getCurrMovieList().clear();
        for (Movie movie : ((MoviesPage) session.getCurrPage()).getMovies()) {
            session.getCurrMovieList().add(movie);
        }
    }
}
