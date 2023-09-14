package database.pages;

import utils.PageName;

public class UpgradesPage extends Page {
    /* Constructor */
    public UpgradesPage() {
        super();
        setType(PageName.UPGRADES);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageName.AUTHENTICATED);
        getNextPages().add(PageName.MOVIES);
        getNextPages().add(PageName.LOGOUT);
    }
}
