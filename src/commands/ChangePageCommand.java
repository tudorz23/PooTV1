package commands;

import client.Session;
import pages.PageFactory;
import fileInput.ActionInput;
import utils.PageName;

public class ChangePageCommand implements ICommand {
    private Session session;
    private ActionInput actionInput;
    private PageFactory pageFactory;

    /* Constructor */
    public ChangePageCommand(Session session, ActionInput actionInput) {
        this.session = session;
        this.actionInput = actionInput;
        pageFactory = new PageFactory();
    }

    public void execute() {
        checkValidity();
    }

    /**
     * Checks if the wanted page can be accessed from the current page.
     */
    private void checkValidity() {
        PageName nextPage = PageName.fromString(actionInput.getPage());
        PageName currPageType = session.getCurrPage().getType();

        // Cannot change page on command from LoginPage or RegisterPage
        if (currPageType == PageName.LOGIN || currPageType == PageName.REGISTER) {
            // Return to UnauthenticatedHomepage
            session.setCurrPage(pageFactory.createPage(PageName.UNAUTHENTICATED));
            //TODO: print error
            return;
        }

        // Check if nextPage is part of currPage's nextPages list.
        if (!session.getCurrPage().getNextPages().contains(nextPage)) {

        }
    }

    private void treatError() {
        PageName currPageType = session.getCurrPage().getType();


    }
}
