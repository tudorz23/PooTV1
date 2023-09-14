package utils;

import commands.CommandFactory;

public enum CommandName {
    CHANGE_PAGE("change page"),
    REGISTER("register"),
    LOGIN("login"),
    SEARCH("search"),
    FILTER("filter"),
    BUY_TOKENS("buy tokens"),
    BUY_PREMIUM_ACCOUNT("buy premium account"),
    PURCHASE("purchase"),
    WATCH("watch"),
    LIKE("like"),
    RATE("rate"),
    LOGOUT("logout");

    public final String label;

    CommandName(String label) {
        this.label = label;
    }

    public static CommandName fromString(String text) {
        for (CommandName commandName : CommandName.values()) {
            if (commandName.label.equals(text)) {
                return commandName;
            }
        }
        return null;
    }
}
