package game.Exceptions;

/**
 * Exception called when the method run does not fit the current game status.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class gameStatusIllegalAction extends Exception {

    /**
     * Exception constructor.
     */
    public gameStatusIllegalAction() {

    }

    /**
     * Exception constructor with a message.
     * 
     * @param msg is the message to be shown in the console.
     */
    public gameStatusIllegalAction(String msg) {
        super(msg);
    }
}
