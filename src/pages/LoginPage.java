package pages;

import utils.PageName;

public class LoginPage extends Page {
    /* Constructor */
    public LoginPage() {
        super();
        setType(PageName.LOGIN);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.UNAUTHENTICATED);
        getNextPages().add(PageName.AUTHENTICATED);
    }
}
