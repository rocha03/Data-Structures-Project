package datastructs.Exceptions;

/**
 * Exception called when a Collection is empty.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class EmptyCollectionException extends Exception {

    /**
     * Exception constructor.
     */
    public EmptyCollectionException() {
        super();
    }

    /**
     * Exception constructor with a message.
     * 
     * @param msg is the message to be shown in the console.
     */
    public EmptyCollectionException(String msg) {
        super(msg);
    }
}
