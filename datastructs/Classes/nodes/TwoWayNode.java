package datastructs.Classes.nodes;

/**
 * Two way linear node class.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class TwoWayNode<T> {
    /**
     * Node element.
     */
    private T element;
    /**
     * Next node.
     */
    private TwoWayNode<T> next;
    /**
     * Previous node.
     */
    private TwoWayNode<T> previous;

    /**
     * Constructor for when the element is known.
     * 
     * @param element is the node's element.
     */
    public TwoWayNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructor for when the element is unknown.
     */
    public TwoWayNode() {
        this.element = null;
        this.next = null;
        this.previous = null;
    }

    /**
     * Obtains the node's element.
     * 
     * @return the node's element.
     */
    public T getElement() {
        return element;
    }

    /**
     * Defines the node's element.
     * 
     * @param element the element that will be saved.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Obtains the next node in the structure.
     * 
     * @return the next node.
     */
    public TwoWayNode<T> getNext() {
        return next;
    }

    /**
     * Defines the node that will come next in the structure.
     * 
     * @param next the next node.
     */
    public void setNext(TwoWayNode<T> next) {
        this.next = next;
    }

    /**
     * Obtains the node that comes before in the structure.
     * 
     * @return the previous node.
     */
    public TwoWayNode<T> getPrevious() {
        return previous;
    }

    /**
     * Defines the node that comes before in the structure.
     * 
     * @param previous the previous node.
     */
    public void setPrevious(TwoWayNode<T> previous) {
        this.previous = previous;
    }
}
