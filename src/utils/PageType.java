package utils;

public enum PageType {
    UNAUTHENTICATED("logout"),
    LOGIN("login"),
    REGISTER("register"),
    AUTHENTICATED("authenticated"),
    MOVIES("movies"),
    SEE_DETAILS("see details"),
    UPGRADES("upgrades");

    public final String label;

    PageType(String label) {
        this.label = label;
    }

    public static PageType fromString(String text) {
        for (PageType pageType : PageType.values()) {
            if (pageType.label.equals(text)) {
                return pageType;
            }
        }
        return null;
    }
}
