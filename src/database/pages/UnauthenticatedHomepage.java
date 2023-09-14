package database.pages;

import utils.PageName;

public class UnauthenticatedHomepage extends Page {

    /* Constructor */
    public UnauthenticatedHomepage() {
        super();
        setType(PageName.UNAUTHENTICATED);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.LOGIN);
        getNextPages().add(PageName.REGISTER);
    }
}
