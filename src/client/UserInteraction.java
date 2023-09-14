package client;

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

public class UserInteraction {
    private Session session;
    private Database database;
    private Invoker invoker;

    private CommandFactory commandFactory;

    private final Input input;
    private ObjectNode output;



    /* Constructor */
    public UserInteraction(Input input, ObjectNode output) {
        this.input = input;
        this.output = output;
        invoker = new Invoker();
    }

    public void startUserInteraction() {
        prepareDatabase();
        initSession();
        commandFactory = new CommandFactory(session);
        parseActions();
        reset();
    }

    /**
     * Instantiates the global Singleton Database and
     * populates it with data taken from the input.
     */
    public void prepareDatabase() {
        // First call of Database.getInstance().
        this.database = Database.getInstance();

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

//    public void printDatabase() {
//        ArrayNode registeredUsers = PrinterJson.getUserArrayNode(database.getRegisteredUsers());
//        output.set("users", registeredUsers);
//
//        ArrayNode availableMovies = PrinterJson.getMovieArrayNode(database.getAvailableMovies());
//        output.set("movies", availableMovies);
//    }

    /**
     * Clears the database and the command list for the next tests.
     */
    public void reset() {
        database.reset();
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
        // TODO
        ICommand command = commandFactory.getCommand(actionInput);

        // TODO
        invoker.execute(command);
    }

    /**
     * Initializes a new Session.
     */
    public void initSession() {
        session = new Session();
    }
}
