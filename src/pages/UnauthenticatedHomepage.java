package pages;

import client.Session;
import utils.PageName;

public class UnauthenticatedHomepage extends Page {
    private Session session;

    /* Constructor */
    public UnauthenticatedHomepage() {
        super();
        setType(PageName.UNAUTHENTICATED);
        setNextPages();
    }

    @Override
    public void changeToThis() {

    }

    private void setNextPages() {
        getNextPages().add(PageName.LOGIN);
        getNextPages().add(PageName.REGISTER);
    }
}
