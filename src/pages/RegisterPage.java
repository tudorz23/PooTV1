package pages;

import utils.PageType;

public class RegisterPage extends Page {
    /* Constructor */
    public RegisterPage() {
        super();
        setType(PageType.REGISTER);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.UNAUTHENTICATED);
        getNextPages().add(PageType.AUTHENTICATED);
    }
}
