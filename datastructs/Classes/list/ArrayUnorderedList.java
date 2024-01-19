package datastructs.Classes.list;

import datastructs.Interfaces.UnorderedListADT;
import java.util.NoSuchElementException;

/**
 *
 * @author klotz
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

    public ArrayUnorderedList(){
        super();
    }
    
    public ArrayUnorderedList(int initialCapacity){
        super(initialCapacity);
    }
    
    @Override
    public void addToFront(T element) {
        if(super.size() == list.length){
            super.expandCapacity();
        }
        
        for(int i = last; i > 0; --i){
            list[i] = list[i - 1];
        }
        
        list[0] = element;
        size++;
        last++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if(super.size() == list.length){
            super.expandCapacity();
        }
        
        list[last++] = element;
        size++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws NoSuchElementException{
        if(super.size() == list.length){
            super.expandCapacity();
        }
        int index = super.find(target);
        
        if(index == -1){
            throw new NoSuchElementException();
        }
        
        for(int i = last; i > index + 1; --i){
            list[i] = list[i - 1];
        }
        
        list[index + 1] = element;
        last++;
        size++;
        modCount++;
    }
    
}
