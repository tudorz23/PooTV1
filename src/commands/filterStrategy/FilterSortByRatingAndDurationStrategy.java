package commands.filterStrategy;

import client.Session;
import database.Movie;
import java.util.Comparator;

public class FilterSortByRatingAndDurationStrategy implements IFilterStrategy {
    private Session session;
    private String ratingOrder;
    private String durationOrder;

    /* Constructor */
    public FilterSortByRatingAndDurationStrategy(Session session, String ratingOrder,
                                                 String durationOrder) {
        this.session = session;
        this.ratingOrder = ratingOrder;
        this.durationOrder = durationOrder;
    }

    @Override
    public void filter() {
        if (ratingOrder.equals("increasing") && durationOrder.equals("increasing")) {
            session.getCurrMovieList().sort(Comparator.comparingInt(Movie::getDuration)
                    .thenComparingDouble(Movie::getRating));
        } else if (ratingOrder.equals("decreasing") && durationOrder.equals("increasing")) {
            session.getCurrMovieList().sort(Comparator.comparingInt(Movie::getDuration)
                    .thenComparingDouble(Movie::getRating).reversed());
        } else if (ratingOrder.equals("increasing") && durationOrder.equals("decreasing")) {
            session.getCurrMovieList().sort(Comparator.comparingInt(Movie::getDuration)
                    .reversed().thenComparingDouble(Movie::getRating));
        } else if (ratingOrder.equals("decreasing") && durationOrder.equals("decreasing")) {
            session.getCurrMovieList().sort(Comparator.comparingInt(Movie::getDuration)
                    .reversed().thenComparingDouble(Movie::getRating).reversed());
        }
    }
}
