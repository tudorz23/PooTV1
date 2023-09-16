package commands;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileInput.ActionInput;

public class CommandFactory {
    private Session session;
    private ArrayNode output;

    /* Constructor */
    public CommandFactory(Session session, ArrayNode output) {
        this.session = session;
        this.output = output;
    }

    public ICommand getCommand(ActionInput actionInput, ArrayNode output) {
        if (actionInput.getType().equals("change page")) {
            return new ChangePageCommand(session, actionInput, output);
        }

        // Now, it surely is an "on page" command.
        // TODO
        // switch for "feature"

        return null;
    }
}
