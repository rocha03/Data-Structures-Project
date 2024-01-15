package datastructs.Exceptions;

/**
 * Exception called when an element is unknown.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class ElementNotFoundException extends Exception {

    /**
     * Exception constructor.
     */
    public ElementNotFoundException() {
    }
    
    /**
     * Exception constructor with a message.
     * 
     * @param msg is the message to be shown in the console.
     */
    public ElementNotFoundException(String msg){
        super(msg);
    }
}
