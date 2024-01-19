package datastructs.Interfaces;

/**
 *
 * @author klotz
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T>{
    
    /**
     * Adds an element at the start of the list.
     * 
     * @param element is the element to add.
     * @return the added element.
     */
    void addToFront(T element);
    
    void addToRear(T element);
    
    void addAfter(T element, T target);
    
}
