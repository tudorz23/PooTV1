package commands;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import commands.changePageStrategy.ChangeToAuthenticatedStrategy;
import commands.changePageStrategy.ChangeToUnauthenticatedStrategy;
import database.Credentials;
import database.Database;
import database.User;
import fileInput.ActionInput;
import fileInput.CredentialsInput;
import fileOutput.PrinterJson;
import utils.PageType;


public class RegisterCommand implements ICommand {
    private Session session;
    private ActionInput actionInput;
    private ArrayNode output;

    /* Constructor */
    public RegisterCommand(Session session, ActionInput actionInput, ArrayNode output) {
        this.session = session;
        this.actionInput = actionInput;
        this.output = output;
    }

    @Override
    public void execute() {
        PrinterJson printerJson = new PrinterJson();
        if (session.getCurrPage().getType() != PageType.REGISTER) {
            printerJson.printError(output);
            return;
        }

        if (!testValidity()) {
            printerJson.printError(output);

            // Move to Unauthenticated Homepage.
            ChangeToUnauthenticatedStrategy failedRegisterStrategy
                    = new ChangeToUnauthenticatedStrategy(session, output);
            failedRegisterStrategy.changePage();

            return;
        }

        // Add the new user in the database.
        Credentials newCredentials = new Credentials(actionInput.getCredentials());
        User newUser = new User(newCredentials);
        Database.getInstance().getRegisteredUsers().add(newUser);

        // Set the new user in the session and move to Authenticated Homepage.
        session.setCurrUser(newUser);
        ChangeToAuthenticatedStrategy succeededRegisterStrategy
                = new ChangeToAuthenticatedStrategy(session, output);
        succeededRegisterStrategy.changePage();

        printerJson.printSuccess(session.getCurrMovieList(), session.getCurrUser(), output);
    }

    /**
     * Checks if there is already a user in the database with given name.
     * @return true if there is, false otherwise.
     */
    private boolean testValidity() {
        CredentialsInput credentialsInput = actionInput.getCredentials();
        String nameInput = credentialsInput.getName();

        for (User user : Database.getInstance().getRegisteredUsers()) {
            if (nameInput.equals(user.getCredentials().getName())) {
                return false;
            }
        }
        return true;
    }
}
