package fileOutput;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ErrorPrinter {
    private final ObjectMapper mapper = new ObjectMapper();

    public void printError(ArrayNode output) {
        ObjectNode errorMessage = mapper.createObjectNode();
        errorMessage.put("error", "Error");

        ArrayNode currentMoviesList = mapper.createArrayNode();
        errorMessage.set("currentMoviesList", currentMoviesList);

        ObjectNode currentUser = mapper.createObjectNode();
        errorMessage.set("currentUser", currentUser);

        output.add(errorMessage);
    }
}
