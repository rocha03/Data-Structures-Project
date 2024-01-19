package datastructs.Classes.stack;

import datastructs.Exceptions.EmptyCollectionException;
import datastructs.Interfaces.StackADT;

public class ArrayStack<T> implements StackADT<T> {
    
    private static final int DEFAULT_CAPACITY = 100;
    
    private int top;
    private T[] stack;
    
    public ArrayStack(){
        this.top = 0;
        this.stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    public ArrayStack(int capacity){
        this.top = 0;
        this.stack = (T[])(new Object[capacity]);
    }

    @Override
    public void push(T element) {
        if(size() == stack.length){
            expandCapacity();
        }
        
        stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Empty");
        }
        
        top--;
        T result = stack[top];
        stack[top] = null;
        
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Empty");
        }
        
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.top;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < size(); i++){
            str += stack[i] + "\n";
        }
        return str;
    }
    
    private void expandCapacity(){
        T[] temp = (T[])(new Object[stack.length * 2]);
        
        for(int i = 0; i < size(); i++){
            temp[i] = stack[i];
        }
        
        stack = temp;
    }
}
