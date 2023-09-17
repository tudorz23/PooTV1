package commands.changePageStrategy;

import client.Session;
import database.User;
import pages.Page;
import pages.PageFactory;
import utils.PageType;

public class ChangeToAuthenticatedStrategy implements IChangePageStrategy {
    private Session session;
    private User user;
    private Page newPage;

    /* Constructor */
    public ChangeToAuthenticatedStrategy(Session session, User user) {
        this.session = session;
        this.user = user;
    }

    /**
     * Will only be called from the Login Command, when it is already certain
     * it can be done.
     */
    @Override
    public void changePage() {
        session.setCurrUser(user);
        PageFactory pageFactory = new PageFactory();
        newPage = pageFactory.createPage(PageType.AUTHENTICATED);
        session.setCurrPage(newPage);
    }
}
