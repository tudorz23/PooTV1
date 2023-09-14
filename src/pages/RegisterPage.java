package pages;

import utils.PageName;

public class RegisterPage extends Page {
    /* Constructor */
    public RegisterPage() {
        super();
        setType(PageName.REGISTER);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.UNAUTHENTICATED);
        getNextPages().add(PageName.AUTHENTICATED);
    }
}
