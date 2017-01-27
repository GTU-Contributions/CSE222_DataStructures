package com.mycompany.hw3_mehmed_mustafa_131044084;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mehmed Mustafa 131044084
 * @param <E> E can be any type
 */
public class SpecList<E extends Comparable<E>> extends LinkedList<E> {
    private static final long serialVersionUID = 1L;
    
    /**
     * Default Constructor
     */
    public SpecList(){
        super();
    }
    
    /**
     * 
     * @param c This is the collection which is used for initialization
     */
    public SpecList(Collection<? extends E> c){
        super(c);
    }
    
    /**
     * 
     * @param c This is the collection containing elements to be added at the head of this list.
     * @return This method returns true if this list changed as a result of the call.
     */
    public boolean addAllAtHead(Collection<? extends E> c){
        boolean status = false;
        try{
            status = super.addAll(0, c);
        }catch(NullPointerException ex){
            System.out.println("Error occured in addAllAtHead method, please contact the administrator!");
            return status;
        }
        
        return status;
    }
    
    /**
     * 
     * @param c This is the collection containing elements to be added at the head of this list.
     * @return This method returns new list containing the intersection of both collections
     */
    public List<E> getIntersectList(Collection<? extends E> c){
        SpecList<E> intersectList = new SpecList<>();
        Iterator specIter = super.iterator();
        try{
            while(specIter.hasNext()){
                // Get the element from the list
                E temp = (E)specIter.next();
                // If the collection contains the same element
                // contains methodunun time complexitisy O(n)
                if(c.contains(temp)){
                    // check if this element is already in the intersection list
                    if(!intersectList.contains(temp))
                    // add this element to the intersection list
                    intersectList.add(temp);
                }
            }
        }catch(NullPointerException ex){
            System.out.println("Error occured in getIntersectList method, please contact the administrator!");
        }
        
        return intersectList;
    }
    
    /**
     * 
     * @return This method sorts the list of the object from lower to bigger values and returns it
     */
    public List<E> sortList(){
        boolean changed;
        
        do{
            changed = false;
            for(int i=0; i<=this.size()-2; ++i){
           //test whether the two elements are in the wrong order
                if(this.get(i).compareTo(this.get(i+1)) > 0){
                    // Change the elements in the right order
                    E temp = this.get(i);
                    this.set(i, this.get(i+1));
                    this.set(i+1, temp);
                    changed = true;
                }
                
            }
            if(!changed){
                //Exit the loop if no elements have been changed
                break;
            }
            changed = false;
            for(int i=this.size()-2; i>=0; --i){
                if(this.get(i).compareTo(this.get(i+1)) > 0){
                    E temp = this.get(i);
                    this.set(i, this.get(i+1));
                    this.set(i+1, temp);
                    changed = true;
                }
            }
            
   //if no elements have been changed, then the list is sorted
        }while(changed);
        
        return this;
    }
    
    /**
     * 
     * @param ignoreMe used to indicate that we want sorting from bigger to lower values
     * @return This method sorts the list of the object from bigger to lower values and returns it
     */
    public List<E> sortList(int ignoreMe){
        boolean changed;
        
        do{
            changed = false;
            for(int i=0; i<=this.size()-2; ++i){
                //test whether the two elements are in the wrong order
                if(this.get(i).compareTo(this.get(i+1)) < 0){
                    // Change the elements in the right order
                    E temp = this.get(i);
                    this.set(i, this.get(i+1));
                    this.set(i+1, temp);
                    changed = true;
                }
                
            }
            if(!changed){
                //Exit the loop if no elements have been changed
                break;
            }
            changed = false;
            for(int i=this.size()-2; i>=0; --i){
                if(this.get(i).compareTo(this.get(i+1)) < 0){
                    E temp = this.get(i);
                    this.set(i, this.get(i+1));
                    this.set(i+1, temp);
                    changed = true;
                }
            }
            
        //if no elements have been changed, then the list is sorted
        }while(changed);
        
        return this;
    }
    
}