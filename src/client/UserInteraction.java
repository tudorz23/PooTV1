package client;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import commands.CommandFactory;
import commands.ICommand;
import database.Database;
import database.Movie;
import database.Credentials;
import database.User;
import fileInput.ActionInput;
import fileInput.Input;
import fileInput.MovieInput;
import fileInput.UserInput;
import fileOutput.PrinterJson;

public class UserInteraction {
    private Session session;
    private Database database;
    private Invoker invoker;

    private CommandFactory commandFactory;

    private final Input input;
    private ArrayNode output;
    private ObjectNode dummyOutput;

    /* Constructor */
    public UserInteraction(Input input, ArrayNode output, ObjectNode dummyOutput) {
        this.input = input;
        this.output = output;
        this.dummyOutput = dummyOutput;
        invoker = new Invoker();
    }

    public void startUserInteraction() {
        prepareDatabase();
        initSession();
        commandFactory = new CommandFactory(session, output);
        parseActions();
        // printDatabase();
        reset();
    }

    /**
     * Instantiates the global Singleton Database and
     * populates it with data taken from the input.
     */
    public void prepareDatabase() {
        // First call of Database.getInstance().
        this.database = new Database();

        // Populate database with registered users.
        for (UserInput userInput : input.getUsers()) {
            Credentials credentials = new Credentials(userInput.getCredentials());
            User user = new User(credentials);
            database.getRegisteredUsers().add(user);
        }

        // Populate database with available movies.
        for (MovieInput movieInput : input.getMovies()) {
            Movie movie = new Movie(movieInput);
            database.getAvailableMovies().add(movie);
        }
    }

    public void printDatabase() {
        PrinterJson printerJson = new PrinterJson();
        ArrayNode registeredUsers = printerJson.getUserArrayNode(database.getRegisteredUsers());
        dummyOutput.set("users", registeredUsers);

        ArrayNode availableMovies = printerJson.getMovieArrayNode(database.getAvailableMovies());
        dummyOutput.set("movies", availableMovies);
    }

    /**
     * Clears the database and the command list for the next tests.
     */
    public void reset() {
        invoker.reset();
    }

    /**
     * Iterates through the actions from the input.
     */
    public void parseActions() {
        for (ActionInput actionInput : input.getActions()) {
            executeAction(actionInput);
        }
    }

    private void executeAction(ActionInput actionInput) {
        ICommand command = commandFactory.getCommand(actionInput);

        invoker.execute(command);
    }

    /**
     * Initializes a new Session.
     */
    public void initSession() {
        session = new Session(database);
    }
}
