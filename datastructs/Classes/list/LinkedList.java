package datastructs.Classes.list;

import datastructs.Classes.nodes.OneWayNode;
import datastructs.Exceptions.ElementNotFoundException;
import datastructs.Exceptions.EmptyCollectionException;

/**
 * Linked list class.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class LinkedList<T> {
    /**
     * Head node sentinell.
     */
    private OneWayNode<T> head;
    /**
     * Tail node sentinell.
     */
    private OneWayNode<T> tail;
    /**
     * Number of nodes in the list.
     */
    private int counter;

    /**
     * Constructor.
     */
    public LinkedList() {
        this.counter = 0;
        this.head = new OneWayNode<>();
        this.tail = new OneWayNode<>();
        this.head.setNext(this.tail);
    }

    /**
     * Method that adds a node to the list.
     * 
     * @param data the node's data.
     */
    public void add(T data) {
        OneWayNode<T> newNode = new OneWayNode<T>(data);
        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);
        this.counter++;
    }

    /**
     * Method that removes the first node from the list.
     * 
     * @throws EmptyCollectionException when the list is empty.
     */
    public void remove() throws EmptyCollectionException {
        if (counter != 0) {
            this.head.setNext(this.head.getNext().getNext());
            counter--;
        } else {
            throw new EmptyCollectionException();
        }
    }

    /**
     * Method that removes a node from the list.
     * 
     * @throws EmptyCollectionException when the list is empty.
     * @throws ElementNotFoundException when the element inserted is invalid.
     */
    public void remove(int n) throws EmptyCollectionException, ElementNotFoundException {
        if (n <= 0 || this.head.getNext() == this.tail) {
            throw new EmptyCollectionException();
        }
        if (n == 1) {
            this.head.setNext(this.head.getNext().getNext());
            this.counter--;
        } else {
            OneWayNode<T> current = this.head.getNext();
            int count = 1;

            while (count < n - 1 && current.getNext() != this.tail) {
                current = current.getNext();
                count++;
            }

            if (current.getNext() == this.tail) {
                throw new ElementNotFoundException();
            } else {
                current.setNext(current.getNext().getNext());
                this.counter--;
            }
        }
    }

    /**
     * @hidden
     */
    public void display() {
        OneWayNode<T> display = this.head.getNext();

        for (int i = 0; i < this.counter; i++) {
            System.out.print("" + display.getElement() + " ");
            display = display.getNext();
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "LinkedList [counter=" + counter + "]";
    }
}
