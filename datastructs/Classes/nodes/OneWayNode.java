package datastructs.Classes.nodes;

/**
 * One way linear node class.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class OneWayNode<T> {
    /**
     * Node element.
     */
    private T element;
    /**
     * Next node.
     */
    private OneWayNode<T> next;

    /**
     * Constructor for when the element is known.
     * 
     * @param element is the node's element.
     */
    public OneWayNode(T element) {
        this.element = element;
        this.next = null;
    }

    /**
     * Constructor for when the element is unknown.
     */
    public OneWayNode() {
        this.element = null;
        this.next = null;
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
    public OneWayNode<T> getNext() {
        return next;
    }

    /**
     * Defines the node that will come next in the structure.
     * 
     * @param next the next node.
     */
    public void setNext(OneWayNode<T> next) {
        this.next = next;
    }
}