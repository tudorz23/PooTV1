package commands;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import commands.changePageStrategy.*;
import fileInput.ActionInput;
import utils.PageType;

public class ChangePageCommand implements ICommand {
    private Session session;
    private ActionInput actionInput;
    private ArrayNode output;

    /* Constructor */
    public ChangePageCommand(Session session, ActionInput actionInput, ArrayNode output) {
        this.session = session;
        this.actionInput = actionInput;
        this.output = output;
    }

    /**
     * Executes the changePage() method of IChangePageStrategy.
     */
    @Override
    public void execute() {
        IChangePageStrategy changePageStrategy = getChangeStrategy();
        changePageStrategy.changePage();
    }

    /**
     * Factory method to get the appropriate change page strategy.
     * @return strategy of type IChangePageStrategy.
     * @throws IllegalArgumentException if the changePage argument is invalid.
     */
    private IChangePageStrategy getChangeStrategy() {
        String stringPageName = actionInput.getPage();

        PageType changePageType = PageType.fromString(stringPageName);

        if (changePageType == null) {
            throw new IllegalArgumentException("There is no " + stringPageName
                        + " page type.");
        }

        switch (changePageType) {
            case UNAUTHENTICATED -> {
                return new ChangeToUnauthenticatedStrategy(session, output);
            }
            case LOGIN -> {
                return new ChangeToLoginStrategy(session, output);
            }
            case REGISTER -> {
                return new ChangeToRegisterStrategy(session, output);
            }
            case MOVIES -> {
                return new ChangeToMoviesStrategy(session, output);
            }
            case SEE_DETAILS -> {
                return new ChangeToSeeDetailsStrategy(session, output,
                        actionInput.getMovie());
            }
            case UPGRADES -> {
                return new ChangeToUpgradesStrategy(session, output);
            }
            case AUTHENTICATED -> {
                return new ChangeToAuthenticatedStrategy(session, output);
            }
            default -> {
                throw new IllegalArgumentException("Page " + stringPageName + " is not supported.");
            }
        }
    }
}
