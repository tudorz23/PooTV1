package pages;

import utils.PageType;

public class UpgradesPage extends Page {
    /* Constructor */
    public UpgradesPage() {
        super();
        setType(PageType.UPGRADES);
        setNextPages();
    }

    private void setNextPages() {
        getNextPages().add(PageType.AUTHENTICATED);
        getNextPages().add(PageType.MOVIES);
        getNextPages().add(PageType.UNAUTHENTICATED);
    }
}
