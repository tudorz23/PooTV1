package pages;

import utils.PageName;

public class PageFactory {
    public Page createPage(PageName type) {
        switch (type) {
            case UNAUTHENTICATED, LOGOUT -> {
                return new UnauthenticatedHomepage();
            }
            case LOGIN -> {
                return new LoginPage();
            }
            case REGISTER -> {
                return new RegisterPage();
            }
            case AUTHENTICATED -> {
                return new AuthenticatedHomepage();
            }
            case MOVIES -> {
                return new MoviesPage();
            }

            case SEE_DETAILS -> {
                return new SeeDetailsPage();
            }
            case UPGRADES -> {
                return new UpgradesPage();
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
