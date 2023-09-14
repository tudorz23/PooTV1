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

    public final String label;

    PageName(String label) {
        this.label = label;
    }

    public static PageName fromString(String text) {
        for (PageName pageName : PageName.values()) {
            if (pageName.label.equals(text)) {
                return pageName;
            }
        }
        return null;
    }
}
