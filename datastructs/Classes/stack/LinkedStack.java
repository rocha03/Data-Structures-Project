package datastructs.Classes.stack;

import datastructs.Classes.nodes.OneWayNode;
import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.StackADT;

public class LinkedStack<T> implements StackADT<T>{
    
    private OneWayNode<T> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        OneWayNode<T> newNode = new OneWayNode<>(element);
        newNode.setNext(this.top);
        this.top = newNode;
        size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Stack Vazia");
        }
        
        OneWayNode<T> previous = this.top;
        
        this.top = top.getNext();
        previous.setNext(null);
        
        size--;
        return previous.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Stack Vazia");
        }
        
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public String toString(){
        String str = "";
        OneWayNode<T> current = this.top;
        
        while(current != null){
            str += current.getElement() + "\n";
            current = current.getNext();
        }
        
        return str;
    }
    
}
