package datastructs.Classes.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import datastructs.Classes.nodes.TwoWayNode;
import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.ListADT;

/**
 * Doubly linked list class
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 * @todo add, contains and iteration functions
 */
public class DoublyLinkedList<T> implements ListADT<T> {
    
    /**
     * Last node.
     */
    private TwoWayNode<T> first;
    /**
     * First node.
     */
    private TwoWayNode<T> last;
    /**
     * Number of nodes in the list.
     */
    private int size;
    /**
     * 
     */
    private int modCount;
    
    /**
     * Constructor.
     */
    public DoublyLinkedList(){
        this.modCount = 0;
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public T addFirst(T element) {
        throw new UnsupportedOperationException("Not supported yet.'"); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        T removed = first.getElement();
        this.first = first.getNext();
        this.first.setPrevious(null);
        size--;
        modCount--;
        return removed;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        T removed = last.getElement();
        this.last = last.getPrevious();
        if(this.last == null){
            this.first = null;
        }else{
            this.last.setNext(null);
        }
        size--;
        modCount--;
        return removed;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public T remove(T element) throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        TwoWayNode<T> removed = find(element);
        
        if(size() == 1){
            first = last = null;
            size--;
        }else if(element.equals(this.first)){
            removeFirst();
        }else if(element.equals(this.last)){
            removeLast();
        }else{
            removed.getPrevious().setNext(removed.getNext());
            removed.getNext().setPrevious(removed.getPrevious());
            size--;
        }
        return removed.getElement();
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return this.first.getElement();
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public T last() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return this.last.getElement();
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean contains(T target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Finds a node in the list by its element.
     * @param element is the element used to search.
     * @return the node once found.
     * @throws NoSuchElementException when the element inserted is invalid.
     */
    private TwoWayNode<T> find(T element) throws NoSuchElementException{
        TwoWayNode<T> current = first;
        
        while(current != null){
            if(current.getElement().equals(element)){
                return current;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException();
        
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public String toString() {
        return "DoublyLinkedList [size=" + size + ", modCount=" + modCount + "]";
    }
}
