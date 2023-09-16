package pages;

import utils.PageType;

public class LoginPage extends Page {
    /* Constructor */
    public LoginPage() {
        super();
        setType(PageType.LOGIN);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.UNAUTHENTICATED);
        getNextPages().add(PageType.AUTHENTICATED);
    }
}
