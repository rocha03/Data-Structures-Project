package datastructs.Classes.queue;

import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.QueueADT;

/**
 *
 * @author klotz
 */
public class CircularArrayQueue<T> implements QueueADT<T>{
    
    private static final int DEFAULT_CAPACITY = 10;
    
    private int rear, size, front;
    private T[] queue;
    
    public CircularArrayQueue(){
        this.rear = this.size = this.front = 0;
        this.queue = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    public CircularArrayQueue(int capacity){
        this.rear = this.size = this.front = 0;
        this.queue = (T[])(new Object[capacity]);
    }

    @Override
    public void enqueue(T element) {
        if(this.queue.length == size()){
            expandCapacity();
        }
        
        queue[rear] = element;
        rear = (rear+1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue Vazia");
        }
        
        T result = queue[front];
        queue[front] = null;

        front = (front+1) % queue.length;

        size--;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue Vazia");
        }
        
        return queue[this.front];
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
        String result = "";
        int scan = 0;
        int counter = 1;

        while(scan < queue.length){
            if(queue[scan]!=null){
                result += counter + ".|" + queue[scan].toString() + "|\n" ;
            }
            else{
                result += counter + "." + "|  |\n";
            }
        scan++;
        counter++;
        }

        return result;
    }
    
    private void expandCapacity(){
        T[] temp = (T[])(new Object[queue.length * 2]);
        
        for(int i = 0; i < size(); i++){
            temp[i] = queue[i];
        }
        
        queue = temp;
    }
}
