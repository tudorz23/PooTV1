package commands.changePageStrategy;

import client.Session;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileOutput.ErrorPrinter;
import pages.PageFactory;
import utils.PageType;

public class ChangeToUnauthenticatedStrategy implements IChangePageStrategy{
    private Session session;
    private ArrayNode output;

    /* Constructor */
    public ChangeToUnauthenticatedStrategy(Session session, ArrayNode output) {
        this.session = session;
        this.output = output;
    }

    @Override
    public void changePage() {
        if (!testValidity()) {
            return;
        }

        session.setCurrUser(null);
        session.getCurrMovieList().clear();
        PageFactory pageFactory = new PageFactory();
        session.setCurrPage(pageFactory.createPage(PageType.UNAUTHENTICATED));
    }

    /**
     * Checks if the changePage command is valid.
     * @return true if it is valid, false otherwise.
     */
    private boolean testValidity() {
        if (!session.getCurrPage().getNextPages().contains(PageType.UNAUTHENTICATED)) {
            ErrorPrinter errorPrinter = new ErrorPrinter();
            errorPrinter.printError(output);
            return false;
        }
        return true;
    }
}
