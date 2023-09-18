package commands;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileInput.ActionInput;
import utils.CommandType;

public class CommandFactory {
    private Session session;
    private ArrayNode output;

    /* Constructor */
    public CommandFactory(Session session, ArrayNode output) {
        this.session = session;
        this.output = output;
    }

    public ICommand getCommand(ActionInput actionInput) {
        // If it is a "change page" command.
        if (actionInput.getType().equals("change page")) {
            return new ChangePageCommand(session, actionInput, output);
        }

        // Now, it surely is an "on page" command.
        CommandType commandType = CommandType.fromString(actionInput.getFeature());

        if (commandType == null) {
            throw new IllegalArgumentException("Command " + actionInput.getFeature()
                        + " is not supported.");
        }

        switch (commandType) {
            case LOGIN -> {
                return new LoginCommand(session, actionInput, output);
            }
            case REGISTER -> {
                return new RegisterCommand(session, actionInput, output);
            }
            case LOGOUT -> {
                return new LogoutCommand(session, output);
            }
            case SEARCH -> {
                return new SearchCommand(session, actionInput, output);
            }
            default -> throw new IllegalArgumentException("Command not yet implemented.");
        }
    }
}
