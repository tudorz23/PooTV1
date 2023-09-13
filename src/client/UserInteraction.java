package client;

import database.Database;
import fileInput.Input;

public class UserInteraction {
    private Session session;
    private Input input;

    /**
     * Iterates through the actions from the input.
     */
    public void parseActions() {

    }

    /**
     * Instantiates the global Singleton Database and
     * populates it with data taken from the input.
     */
    public void prepareDatabase() {
        Database database = Database.getInstance();
    }

    public void initSession() {
        session = new Session();

    }
}
