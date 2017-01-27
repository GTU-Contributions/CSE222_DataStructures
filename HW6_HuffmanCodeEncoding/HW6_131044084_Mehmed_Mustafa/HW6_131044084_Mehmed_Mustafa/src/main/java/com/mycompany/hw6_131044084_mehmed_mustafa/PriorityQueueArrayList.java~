package com.mycompany.hw6_131044084_mehmed_mustafa;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Mehmed Mustafa
 */
public class PriorityQueueArrayList<E> extends AbstractQueue <E> implements Queue<E>
{
    // Data Fields
    /** The ArrayList to hold the data. */
    private ArrayList<E> theData;

    /** An optional reference to a Comparator object. */
    Comparator<E> comparator = null;

    // Methods
    // Constructor
    public PriorityQueueArrayList() {
      theData = new ArrayList<>();
    }
    
    /** Compare two items using either a Comparator object’s compare method
     or their natural ordering using method compareTo.
     pre: If comparator is null, left and right implement Comparable<E>.
     @param left One item
     @param right The other item
     @return Negative int if left less than right,
        0 if left equals right,
        positive int if left > right
     @throws ClassCastException if items are not Comparable
    */
    private int compare(E left, E right) {
        if (comparator != null){ // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else{ // Use left’s compareTo method.
            return ((Comparable <E>) left).compareTo(right);
        }
    }
    
    /**
     * 
     * @return The size of the queue
     */
    @Override
    public int size(){
        return theData.size();
    }
    
    /**
     * 
     * @return True if the queue is empty
     */    
    @Override
    public boolean isEmpty(){
        return theData.isEmpty();
    }

    /**
     * 
     * @param e The object to add
     * @return True if the object is added to te queue
     */
    @Override
    public boolean offer(E e){ 
        if(e == null || theData == null)
            return false;
        if(theData.isEmpty())
        {
            theData.add(e);
        }
        else
        {
            for(int i=0; i<theData.size(); ++i)
            {
                if(compare(theData.get(i), e) > 0)
                {
                    theData.add(i, e);
                    return true;
                }
                
            }
            
            theData.add(e);
        }
        
        return true;
    }
    
    public boolean removeElement(E e){
        int indexOfElement;
        if((indexOfElement = theData.indexOf(e)) != -1)
        {
            theData.remove(indexOfElement);
            return true;
        }
        else
            return false;
    }
    
    /**
     * 
     * @return The removed object item from the front
     */
    @Override
    public E poll() {
        if(theData.isEmpty())
            return null;
        else
            return theData.remove(0);
    }
    
    /**
     * 
     * @return The object item which is on the frond
     */
    @Override
    public E peek() {
        if(theData.isEmpty())
            return null;
        else
            return theData.get(0);
    }

    @Override
    public Iterator<E> iterator() {
        return theData.iterator();
    }
    
}
