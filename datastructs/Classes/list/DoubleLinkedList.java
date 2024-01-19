package datastructs.Classes.list;

import datastructs.Classes.nodes.TwoWayNode;
import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.ListADT;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author klotz
 */
public abstract class DoubleLinkedList<T> implements ListADT<T>{
    
    private TwoWayNode<T> first, last;
    private int size, modCount;
    
    public DoubleLinkedList(){
        this.modCount = 0;
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    
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

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return this.first.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return this.last.getElement();
    }

    @Override
    public boolean contains(T target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private TwoWayNode find(T element) throws NoSuchElementException{
        TwoWayNode current = first;
        
        while(current != null){
            if(current.getElement().equals(element)){
                return current;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException();
        
    }
    
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
