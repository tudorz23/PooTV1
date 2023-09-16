package pages;

import utils.PageType;

public class UnauthenticatedHomepage extends Page {
    /* Constructor */
    public UnauthenticatedHomepage() {
        super();
        setType(PageType.UNAUTHENTICATED);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.LOGIN);
        getNextPages().add(PageType.REGISTER);
    }
}
