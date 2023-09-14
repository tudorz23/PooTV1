package pages;

import utils.PageName;

import java.util.ArrayList;

public abstract class Page {
    private final ArrayList<PageName> nextPages;
    private PageName type;

    /* Constructor */
    public Page() {
        nextPages = new ArrayList<>();
    }

    public abstract void changeToThis();

    /* Getters and Setters */
    public ArrayList<PageName> getNextPages() {
        return nextPages;
    }
    public PageName getType() {
        return type;
    }
    public void setType(PageName type) {
        this.type = type;
    }
}
