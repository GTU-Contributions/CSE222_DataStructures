package com.mycompany.hw7_mehmed_mustafa_131044084;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

/**
 * Priority queue class
 * @author Mehmed Mustafa 131044084
 * @param <E> Data of any type
 */
public class MehmedsPriorityQueue<E> extends AbstractQueue<E> implements Queue<E>
{
    //Data Fields
    /* Data holder */
    private ArrayList<E> theData;
    /* Comparator */
    Comparator<E> comparator = null;

    //Constructors
    /**
     * Default constructor
     */
    public MehmedsPriorityQueue(){
        theData = new ArrayList<>();
    }
    
    /**
     * Constructor with initialized comparator
     * @param comparator 
     */
    public MehmedsPriorityQueue(Comparator<E> comparator){
        theData = new ArrayList<>();
        this.comparator = comparator;
    }
    
    /**
     * Compare method
     * @param object1 First object to compare
     * @param object2 Second object to compare
     * @return The result of the compareTo or comparator method
     */
    private int compare(E object1, E object2){
        if(comparator != null)
            return comparator.compare(object1, object2);
        
        return ((Comparable <E>)object1).compareTo(object2);
    }
    
    /**
     * Checker for emptiness of the queue
     * @return True if the queue is empty
     */
    @Override
    public boolean isEmpty(){
        return theData.isEmpty();
    }
    
    /**
     * Checker for the size of the queue
     * @return The size of the queue
     */
    @Override
    public int size() {
        return theData.size();
    }

    /**
     * Method for adding new element
     * @param element Element to add
     * @return True if successful, false otherwise
     */
    @Override
    public boolean offer(E element){
        if(element == null || theData == null)
            return false;
        
        if(theData.isEmpty())
            theData.add(element);
        else
        {
            for(int i=0; i<theData.size(); ++i)
                if(compare(theData.get(i), element) > 0)
                {
                    theData.add(i, element);
                    return true;
                }
            
            theData.add(element);
        }
        
        return true;
    }

    /**
     * Method for getting and removing the first element of the queue
     * @return The first element of the queue
     */
    @Override
    public E poll(){
        if(theData.isEmpty())
            return null;
        
        return theData.remove(0);
    }

    /**
     * Method for checking the first element of the queue
     * @return The first element of the queue
     */
    @Override
    public E peek(){
        if(theData.isEmpty())
            return null;
        
        return theData.get(0);
    }

    /**
     * Iterator
     * @return Iterator for the queue
     */
    @Override
    public Iterator<E> iterator() {
        return theData.iterator();
    }
    
}
