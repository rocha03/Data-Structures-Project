package datastructs.Classes.list;

import datastructs.Interfaces.OrderedListADT;

/**
 *
 * @author klotz
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T>{

    public ArrayOrderedList(){
        super();
    }
    
    public ArrayOrderedList(int initialCapacity){
        super(initialCapacity);
    }
    
    @Override
    public void add(T element)  throws IllegalArgumentException {
        if(super.size() == list.length){
            super.expandCapacity();
        }
        if(!(element instanceof Comparable<?>)){
            throw new IllegalArgumentException();
        }
        
        Comparable<T> comp = (Comparable<T>) element;
        int position = 0;
        
        while(position < last && comp.compareTo(list[position]) > 0){
            ++position;
        }
        
        for(int i = last; i > position; --i){
            list[i] = list[i - 1];
        }
        
        list[position] = element;
        size++;
        last++;
        modCount++;
    }
    
}
