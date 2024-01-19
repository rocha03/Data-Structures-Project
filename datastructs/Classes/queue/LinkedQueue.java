package datastructs.Classes.queue;

import datastructs.Classes.nodes.OneWayNode;
import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.QueueADT;

/**
 *
 * @author klotz
 */
public class LinkedQueue<T> implements QueueADT<T> {
    
    private OneWayNode<T> front;
    private OneWayNode<T> rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        OneWayNode<T> newNode = new OneWayNode<>(element);
        
        if(this.rear == null){
            this.front = this.rear = newNode;
        }
        
        this.rear.setNext(newNode);
        this.rear = newNode;
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue Vazia");
        }
        
        OneWayNode<T> result = this.front;
        this.front = this.front.getNext();
        result.setNext(null);
        size--;
        
        return result.getElement();
        
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue Vazia");
        }
        
        return this.front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    public String toString(){
        String str = "";
        OneWayNode<T> current = this.front;
        while(current != null){
            str += current.getElement() + "\n";
            current = current.getNext();
        }
        return str;
    }
    
}
