package com.mycompany.hw5_mehmed_mustafa_131044084;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to find Intersection, Union and SubSet of two lists
 * @author Mehmed Mustafa 131044084
 * @param <E> Variable type
 */
public class ListSetOperations<E>{
    // Data fields
    private List<E> myList1 = new ArrayList();
    private List<E> myList2 = new ArrayList();
    
    /**
     * Constructor
     * @param list1 Initialize first list
     * @param list2 Initialize second list
     */
    public ListSetOperations(List<E> list1, List<E> list2){
        this.myList1 = new ArrayList(list1);
        this.myList2 = new ArrayList(list2);
    }

    /**
     * Wrapper method to find the intersection of two lists
     * @return intersection of the two lists
     */
    public List intersectionOfLists(){
        if(myList1 == null || myList2 == null)
            return new ArrayList<>();
        
        ArrayList<E> intersectList = new ArrayList();
        
        // Make work on the smaller list for better performance
        if(myList1.size()<=myList2.size())
            intersection(myList1, myList2, intersectList);
        else
            intersection(myList2, myList1, intersectList);
            
        return intersectList;
    }
    /**
     * Recursive method to find the intersection of two lists
     * @param list1 First list
     * @param list2 Second list
     * @param intersectList List where the intersection is saved
     */
    private void intersection(List<E> list1, List<E> list2, List<E> intersectList){
        if(list1.isEmpty() || list2.isEmpty())
            return;
        
        E temp = list1.get(list1.size()-1);
        if(list2.contains(temp) && !intersectList.contains(temp)){
            intersectList.add(0, temp);
        }
        
        intersection(list1.subList(0, list1.size()-1), list2, intersectList);
        
    }
    /**
     * Wrapper method to find the union of two lists
     * @return union of the two lists
     */
    public List unionOfLists(){
        if(myList1 == null || myList2 == null)
            return new ArrayList<>();
        
        ArrayList<E> unionList = new ArrayList();    
        union(myList1, myList2, unionList);
        
        return unionList;
    }
    /**
     * Recursive method to find the union of two lists
     * @param list1 First list
     * @param list2 Second list
     * @param unionList List where the union is saved
     */
    private void union(List<E> list1, List<E> list2, List<E> unionList){
        if(list1.isEmpty() && list2.isEmpty()){
            return;
        }
        if(list1.isEmpty()){ //When list1 is empty but list1 is not
            E tempEl = list2.get(list2.size()-1);
            if(!unionList.contains(tempEl))
                unionList.add(0, tempEl);
            union(list1, list2.subList(0, list2.size()-1), unionList);
            return;
        }
        if(list2.isEmpty()){ //When list2 is empty but list1 is not
            E tempEl = list1.get(list1.size()-1);
            if(!unionList.contains(tempEl))
                unionList.add(0, tempEl);
            union(list1.subList(0, list1.size()-1), list2, unionList);
            return;
        }
        
        E tempEl1 = list1.get(list1.size()-1);
        E tempEl2 = list2.get(list2.size()-1);
        if(!unionList.contains(tempEl1))
            unionList.add(0, tempEl1);
        if(!unionList.contains(tempEl2))
            unionList.add(0, tempEl2);
        
        union(list1.subList(0, list1.size()-1), list2.subList(0, list2.size()-1), unionList);
    }
    
    /**
     * Wrapper method to check if list2 is sub set of list1
     * @return True if list2 is subset of list1 and false otherwise
     */
    public boolean isSubset(){
        if(myList1 == null || myList2 == null)
            return false;
        if(myList2.size() > myList1.size())
            return false;
        
        return subset(myList1, myList2);
    }
    /**
     * Recursive method to check if list2 is sub set of list1
     * @param list1 First list
     * @param list2 Second list
     * @return True if list2 is subset of list1 and false otherwisse
     */
    private boolean subset(List list1, List list2){
        E tempEl;
        boolean status;
        
        if(list2.isEmpty())
            return true;
        else{
            tempEl = (E)list2.get(list2.size()-1);
            if(list1.contains(tempEl))
                status = subset(list1, list2.subList(0, list2.size()-1));
            else
                status = false;
        }
        
        return status;
    }
}
