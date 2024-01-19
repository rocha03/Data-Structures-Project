package datastructs.Interfaces;

import java.util.Iterator;

import datastructs.Exceptions.EmptyCollectionException;

/**
 * Interface that represents the "Abstract Data Type", or ADT, of a linked list.
 * 
 * @author Alexandre Rocha, Gbriel Klotz
 */
public interface ListADT<T> extends Iterable<T> {

    /**
     * Removes the first node.
     * 
     * @return the element of the removed node.
     * @throws EmptyCollectionException when the list is empty.
     */
    T removeFirst() throws EmptyCollectionException;

    /**
     * Removes the last node.
     * 
     * @return the element of the removed node.
     * @throws EmptyCollectionException when the list is empty.
     */
    T removeLast() throws EmptyCollectionException;

    /**
     * Removes a node matching the element.
     * 
     * @param element the element to match and remove.
     * @return the element of the removed node.
     * @throws EmptyCollectionException when the list is empty.
     */
    T remove(T element) throws EmptyCollectionException;

    /**
     * Gets the first element in the list.
     * 
     * @return the first element.
     * @throws EmptyCollectionException when the list is empty.
     */
    T first() throws EmptyCollectionException;

    /**
     * Gets the last element in the list.
     * 
     * @return the last element.
     * @throws EmptyCollectionException when the list is empty.
     */
    T last() throws EmptyCollectionException;

    /**
     * Checks if an element is part of the list.
     * 
     * @param target is the element to check.
     * @return true if it is, false if it is not.
     */
    boolean contains(T target);

    /**
     * Checks if a list is empty.
     * 
     * @return true if it is, false if it is not.
     */
    boolean isEmpty();

    /**
     * Gets the current size of the list.
     * 
     * @return the int value of the size.
     */
    int size();

    /**
     * {@inheritdoc}
     */
    @Override
    Iterator<T> iterator();

    /**
     * {@inheritdoc}
     */
    @Override
    String toString();

}
