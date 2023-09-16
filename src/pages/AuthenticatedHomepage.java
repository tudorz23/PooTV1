package pages;

import utils.PageType;

public class AuthenticatedHomepage extends Page {
    /* Constructor */
    public AuthenticatedHomepage() {
        super();
        setType(PageType.AUTHENTICATED);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.MOVIES);
        getNextPages().add(PageType.UPGRADES);
        getNextPages().add(PageType.UNAUTHENTICATED);
    }
}
