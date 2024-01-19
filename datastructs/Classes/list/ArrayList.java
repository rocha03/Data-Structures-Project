package datastructs.Classes.list;

import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.ListADT;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author klotz
 * @param <T>
 */
public abstract class ArrayList<T> implements ListADT<T>{

    private static final int DEFAULT_CAPACITY = 20;
    private static final int EXPAND_VALUE = 2;
    private static final int NOT_FOUND = -1;
    
    protected int last, size, modCount;
    protected T[] list;
    
    public ArrayList(){
        this.size = 0;
        this.last = 0;
        list = (T[])(new Object[DEFAULT_CAPACITY]);
        this.modCount = 0;
    }
    
    public ArrayList(int capacity){
        this.size = 0;
        this.last = 0;
        list = (T[])(new Object[capacity]);
        this.modCount = 0;
    }
    
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        T current = list[0];
        for(int i = 0; i < last - 1; i++){
            list[i] = list[i + 1];
        }
        list[--last] = null;
        size--;
        this.modCount++;
        return current;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        T current = list[last - 1];
        list[--last] = null;
        size--;
        this.modCount++;
        return current;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        int index = find(element);
        T current = list[index];
        
        for(int i = index; i < last - 1; i++){
            list[i] = list[i + 1];
        }
        
        list[--last] = null;
        size--;
        this.modCount++;
        return current;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException ("Lista Vazia");
        }
        
        return list[last - 1];
    }

    @Override
    public boolean contains(T target) {
        return find(target) != NOT_FOUND;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    protected int find(T element){
        for(int i = 0; i < last; i++){
            if(list[i].equals(element)){
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    protected void expandCapacity(){
        T[] new_list = (T[])(new Object[list.length * EXPAND_VALUE]);
        for(int i = 0; i < list.length; i++){
            new_list[i] = list[i];
        }
        
        list = new_list;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < last; i++){
            str += "[" + list[i] + "]\n";                
        }
        return str;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public void add(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class MyIterator implements Iterator<T> {

        private int current;
        private int expectedModCount;
        private boolean okToRemove;

        public MyIterator() {
            this.current = 0;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return (current != size());
        }

        @Override
        public T next() {
            if (this.expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.okToRemove = true;
            
            return (T) list[this.current++];
        }

        @Override
        public void remove(){
            if (this.expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!this.okToRemove) {
                throw new NoSuchElementException();
            }
            
            this.okToRemove = false;
            
            try{
                ArrayList.this.remove(list[--this.current]);
                ++this.expectedModCount;
            }catch(EmptyCollectionException ex){
                System.out.println("Coleção Vazia");
            }
        }
    }
}
