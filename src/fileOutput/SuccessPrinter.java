package fileOutput;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.Movie;
import database.User;
import java.util.ArrayList;

public class SuccessPrinter {
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Used when changing to Movies or See Details page.
     * @param currentMoviesList list of movies visible to the user.
     * @param user current logged-in user.
     * @param output ArrayNode for JSON printing.
     */
    public void printMovies(ArrayList<Movie> currentMoviesList, User user, ArrayNode output) {
        ObjectNode message = mapper.createObjectNode();

        message.put("error", (String) null);

        ArrayNode currentMoviesNode = PrinterJson.getMovieArrayNode(currentMoviesList);
        message.set("currentMoviesList", currentMoviesNode);

        ObjectNode currentUser = PrinterJson.getUserNode(user);
        message.set("currentUser", currentUser);

        output.add(message);
    }
}
