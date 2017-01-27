package com.mycompany.hw6_131044084_mehmed_mustafa;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mehmed Mustafa
 */
public class PriorityQueueBST<E> extends AbstractQueue<E> implements Queue<E>
{
    // Data Fields
    /** The BinaryTree to hold the data. */
    private BinaryTree<E> theData;
    /** Size of the binary tree. */
    private int size = 0;
    /** An optional reference to a Comparator object. */
    Comparator<E> comparator = null;
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;
    
    // Methods
    // Constructor
    public PriorityQueueBST(){
      theData = new BinaryTree<>();
    }
    
    public PriorityQueueBST(Comparator<E> comp){
      theData = new BinaryTree<>();
      this.comparator = comp;
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
    protected int compare(E left, E right) {
        if (comparator != null){ // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else{ // Use left’s compareTo method.
            return ((Comparable <E>) left).compareTo(right);
        }
    }  
    
    /**
     * Starter method add.
     * @pre The object to insert must implement the
     *      Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     *         if the object already exists in the tree
     */
    private boolean addElement(E item) {
        theData.root = addElement(theData.root, item);
        return addReturn;
    }

    /**
     * Recursive addElement method.
     * @post The data field addReturn is set true if the item is added to
     *       the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     *         inserted item
     */
    private BinaryTree.Node<E> addElement(BinaryTree.Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree - insert it.
            addReturn = true;
            return new BinaryTree.Node<>(item);
        } else if (compare(item, localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (compare(item, localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = addElement(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = addElement(localRoot.right, item);
            return localRoot;
        }
    }
    
    /**
     * Starter method delete.
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree
     *         or null if the object was not in the tree
     * @throws ClassCastException if target does not implement
     *         Comparable
     */
    private E delete(E target) {
        theData.root = delete(theData.root, target);
        return deleteReturn;
    }

    /**
     * Recursive delete method.
     * @post The item is not in the tree;
     *       deleteReturn is equal to the deleted item
     *       as it was stored in the tree or null
     *       if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain
     *         the item
     */
    private BinaryTree.Node<E> delete(BinaryTree.Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = compare(item, localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    
    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param parent The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(BinaryTree.Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null){
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
            return findLargestChild(parent.right);
    }      
    
    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its right child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param parent The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
    private E findSmallestChild(BinaryTree.Node<E> parent) {        
        // If the left child has no left child, it is
        // the inorder predecessor.
        if (parent.left.left == null){
            E returnValue = parent.left.data;
            parent.left = parent.left.right;
            return returnValue;
        } 
        else
            return findSmallestChild(parent.left);
    }
    
    public class IteratorClass<E> implements Iterator<E>{

        private Stack<BinaryTree.Node> stack = new Stack<>();
        private BinaryTree.Node current;

        public IteratorClass(BinaryTree.Node argRoot) {
            current = argRoot;
        }

        public E next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            BinaryTree.Node<E> node = current;
            current = current.right;

            return node.data;
        }

        public boolean hasNext() {
            return (!stack.isEmpty() || current != null);
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException("Invalid Operation!\n");
        }

    }
    
    private IteratorClass<E> iterator(BinaryTree.Node root){
        return new IteratorClass(root);
    }
    
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) iterator(theData.root);
    }

    /**
     * 
     * @return True if the queue is empty
     */
    @Override
    public boolean isEmpty(){
        return theData.root == null;
    }
    
    /**
     * 
     * @return The size of the queue
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * 
     * @param e The object to add
     * @return True if the object is added to te queue
     */
    @Override
    public boolean offer(E e) {
        boolean status = false;
        
        if(e == null)
            return status;
        
        if(addElement(e))
        {
            ++size;
            status = true;
        }
        
        return status;
    }

    /**
     * 
     * @return The removed object item from the front
     */
    @Override
    public E poll() {        
        if(isEmpty())
            return null;
        else if(theData.root.left == null && theData.root.right == null)
        {
            E data = theData.root.data;
            theData.root = null;
            return data;
        }
        else
        {
            E data = findSmallestChild(theData.root);
            --size;
            return delete(theData.root, data).data;
        }
    }

    /**
     * 
     * @return The object item which is on the frond
     */
    @Override
    public E peek() {
        if(isEmpty())
            return null;
        else
            return findSmallestChild(theData.root);
    }
    
}
