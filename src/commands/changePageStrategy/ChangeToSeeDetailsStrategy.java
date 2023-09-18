package commands.changePageStrategy;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import database.Movie;
import fileOutput.PrinterJson;
import pages.MoviesPage;
import pages.Page;
import pages.PageFactory;
import pages.SeeDetailsPage;
import utils.PageType;

public class ChangeToSeeDetailsStrategy implements IChangePageStrategy{
    private Session session;
    private ArrayNode output;
    private String movieName;
    private Page newPage;

    /* Constructor */
    public ChangeToSeeDetailsStrategy(Session session, ArrayNode output, String movieName) {
        this.session = session;
        this.output = output;
        this.movieName = movieName;
    }

    @Override
    public void changePage() {
        if (!testValidity()) {
            return;
        }

        PageFactory pageFactory = new PageFactory();
        newPage = pageFactory.createPage(PageType.SEE_DETAILS);
        copyMovie();
        session.setCurrPage(newPage);

        PrinterJson successPrinter = new PrinterJson();
        successPrinter.printSuccess(session.getCurrMovieList(),
                                    session.getCurrUser(), output);
    }

    /**
     * Checks if the changePage command is valid.
     * @return true if it is valid, false otherwise.
     */
    private boolean testValidity() {
        // SeeDetailsPage can only be accessed from MoviesPage.
        if (session.getCurrPage().getType() != PageType.MOVIES) {
            PrinterJson errorPrinter = new PrinterJson();
            errorPrinter.printError(output);
            return false;
        }
        return true;
    }

    /**
     * Selects the movie with the respective title from the movies (which is also current)
     * page list and sets it as new page's movie and session's current movie.
     */
    private void copyMovie() {
        for (Movie movie : ((MoviesPage) session.getCurrPage()).getMovies()) {
            if (movie.getName().equals(movieName)) {
                ((SeeDetailsPage) newPage).setMovie(movie);
                break;
            }
        }

        session.getCurrMovieList().clear();
        session.getCurrMovieList().add(((SeeDetailsPage) newPage).getMovie());
    }
}
