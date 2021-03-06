package com.mycompany.hw5_mehmed_mustafa_131044084;

/**
 * Remove all elements of the value passet as argument recursively
 * @author Mehmed Mustafa 131044084
 */
public class LinkedListRec<E> {

    /** A Node is the building block for a single-linked list. */
    private static class Node <E> {
        // Data Fields
        /** The reference to the data. */
        private E data;

        /** The reference to the next node. */
        private Node next;

        // Constructors
        /** Creates a new node with a null next field.
            @param dataItem The data stored
         */
        private Node(E dataItem){
            data = dataItem;
            next = null;
        }

        /** Creates a new node that references another node.
            @param dataItem The data stored
            @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node <E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    } //end class Node
    
    /** The list head */
    private Node<E> head;

    /** Adds a new node to the end of a list.
        @param head The head of the current list
        @param data The data for the new node
     */
    private void add(Node <E> head, E data) {
        // If the list has just one element, add to it.
        if (head.next == null)
            head.next = new Node <E> (data);
        else
            add(head.next, data); // Add to rest of list.
    }

    /** Wrapper method for adding a new node to the end of a list.
        @param data The data for the new node
     */
    public void add(E data) {
        if (head == null)
            head = new Node <E> (data); // List has 1 node.
        else
            add(head, data);
    }

    /** Returns the string representation of a list.
        @param head The head of the current list
        @return The state of the current list
    */
    private String toString(Node < E > head) {
        if (head == null)
            return "";
        else
            return head.data + " " + toString(head.next);
    }

    /** Wrapper method for returning the string representation of a list.
        @return The string representation of the list
     */
    @Override
    public String toString(){
        return toString(head);
    }   
    
    /** Removes same nodes from a list.
        post: All occurrence of outData are removed.
        @param head The head of the current list
        @param pred The predecessor of the list head
        @param outData The data to be removed
        @return true if an item is removed and false otherwise
     */
    public boolean remove(Node <E> head, Node <E> pred, E outData){
        boolean status = false;
         if(pred == null) // Check pred for null
            return status;
         if(pred.data.equals(outData)){
            status = true;
            this.head = head;
            if(head == null) // Check head for null
                return status;
            
            return remove(head.next, head, outData);
        }
        if (head == null)
            return status;
        else if(head.data.equals(outData))
        {   status = true;
            pred.next = head.next;
            if(pred.next == null) // Check pred for null
                return status;
            
            return remove(head.next, pred, outData);
        }
        
        return remove(head.next, head, outData);
    }
    
    /** Wrapper method for removing same nodes (in LinkedListRec).
        post: The first occurrence of outData is removed.
        @param outData The data to be removed
        @return true if an item is removed and false otherwise
     */
    public boolean remove(E outData) {
        boolean status = false;
        
        if (head == null)
            return status;
        else if(head.data.equals(outData))
        {
            head = head.next;
            status = true;
        }
        if(!status)
            status = remove(head.next, head, outData);
        else
            remove(head.next, head, outData);
        
        return status;
    }    
   
}
