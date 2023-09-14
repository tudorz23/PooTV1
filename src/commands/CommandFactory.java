package commands;

import client.Session;
import fileInput.ActionInput;

public class CommandFactory {
    private Session session;

    /* Constructor */
    public CommandFactory(Session session) {
        this.session = session;
    }

    public ICommand getCommand(ActionInput actionInput) {
        // TODO
        return null;
    }
}
