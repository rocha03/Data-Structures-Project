package datastructs.Interfaces;

import datastructs.Exceptions.EmptyCollectionException; 

/**
 *
 * @author klotz
 */
public interface StackADT<T> {
    
    public void push(T element);
    
    public T pop() throws EmptyCollectionException;
    
    public T peek() throws EmptyCollectionException;
    
    public boolean isEmpty();
    
    public int size();
    
    @Override
    public String toString();
    
}
