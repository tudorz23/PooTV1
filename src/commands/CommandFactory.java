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
        if (actionInput.getType().equals("change page")) {
            return new ChangePageCommand(session, actionInput);
        }

        // Now, it surely is an "on page" command.
        // TODO
        // switch for "feature"

        return null;
    }
}
