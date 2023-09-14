package utils;

public enum PageName {
    UNAUTHENTICATED("unauthenticated"),
    LOGIN("login"),
    REGISTER("register"),
    AUTHENTICATED("authenticated"),
    MOVIES("movies"),
    SEE_DETAILS("see details"),
    UPGRADES("upgrades"),
    LOGOUT("logout");

    private final String label;

    PageName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
