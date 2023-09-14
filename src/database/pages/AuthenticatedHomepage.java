package database.pages;

import utils.PageName;

public class AuthenticatedHomepage extends Page {
    /* Constructor */
    public AuthenticatedHomepage() {
        super();
        setType(PageName.AUTHENTICATED);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.MOVIES);
        getNextPages().add(PageName.UPGRADES);
        getNextPages().add(PageName.LOGOUT);
    }
}
