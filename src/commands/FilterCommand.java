package commands;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import commands.filterStrategy.*;
import database.Movie;
import fileInput.ActionInput;
import fileOutput.PrinterJson;
import pages.MoviesPage;
import utils.PageType;

import java.util.ArrayList;

public class FilterCommand implements ICommand {
    private Session session;
    private ActionInput actionInput;
    private ArrayNode output;

    /* Constructor */
    public FilterCommand(Session session, ActionInput actionInput, ArrayNode output) {
        this.session = session;
        this.actionInput = actionInput;
        this.output = output;
    }


    @Override
    public void execute() {
        PrinterJson printerJson = new PrinterJson();

        if (!testValidity()) {
            printerJson.printError(output);
            return;
        }

        // Clear the currently displayed movie list and populate it with the movies from the MoviePage.
        // (thus eliminating any previous filter).
        session.resetCurrMovieList();
        for (Movie movie : ((MoviesPage) session.getCurrPage()).getMovies()) {
            session.getCurrMovieList().add(movie);
        }

        ArrayList<IFilterStrategy> filterStrategies = getFilterStrategies();

        for (IFilterStrategy filterStrategy : filterStrategies) {
            filterStrategy.filter();
        }

        printerJson.printSuccess(session.getCurrMovieList(), session.getCurrUser(), output);
    }

    /**
     * Parses the actionInput and generates Strategies for filtering.
     * @return ArrayList of Strategies to filter by.
     */
    private ArrayList<IFilterStrategy> getFilterStrategies() {
        ArrayList<IFilterStrategy> filterStrategies = new ArrayList<>();

        if (actionInput.getFilters().getContains() != null) {
            ArrayList<String> genres = actionInput.getFilters().getContains().getGenre();
            if (genres != null) {
                IFilterStrategy filterByContainsGenre = new FilterContainsGenreStrategy(session, genres);
                filterStrategies.add(filterByContainsGenre);
            }

            ArrayList<String> actors = actionInput.getFilters().getContains().getActors();
            if (actors != null) {
                IFilterStrategy filterByContainsActor = new FilterContainsActorStrategy(session, actors);
                filterStrategies.add(filterByContainsActor);
            }
        }

        if (actionInput.getFilters().getSort() != null) {
            String rating = actionInput.getFilters().getSort().getRating();
            String duration = actionInput.getFilters().getSort().getDuration();

            if (rating != null && duration != null) {
                IFilterStrategy filterByRatingAndDuration =
                        new FilterSortByRatingAndDurationStrategy(session, rating, duration);
                filterStrategies.add(filterByRatingAndDuration);
            } else if (rating != null) {
                IFilterStrategy filterSortByRating = new FilterSortByRatingStrategy(session, rating);
                filterStrategies.add(filterSortByRating);
            } else if (duration != null) {
                IFilterStrategy filterSortByDuration = new FilterSortByDurationStrategy(session, duration);
                filterStrategies.add(filterSortByDuration);
            }
        }

        return filterStrategies;
    }

    /**
     * Tests if the Filter action is valid.
     * @return true if valid, false otherwise.
     */
    private boolean testValidity() {
        // Current page should be MoviesPage.
        if (session.getCurrPage().getType() != PageType.MOVIES) {
            return false;
        }

        // Check if both filter ways are null.
        if (actionInput.getFilters().getSort() == null
            && actionInput.getFilters().getContains() == null) {
            return false;
        }

        return true;
    }
}
