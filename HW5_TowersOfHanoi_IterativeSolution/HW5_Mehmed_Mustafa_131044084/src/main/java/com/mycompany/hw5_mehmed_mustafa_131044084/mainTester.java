package com.mycompany.hw5_mehmed_mustafa_131044084;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Homework 5
 * @author Mehmed Mustafa 131044084
 */
public class mainTester {
    public static void main(String[] args){
        /* PART 2 */
        LinkedListRec<Integer> myList = new LinkedListRec();
        myList.add(1);
        myList.add(1);
        myList.add(2);
        myList.add(1);
        myList.add(5);
        myList.add(1);
        myList.add(1);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        myList.add(1);
        
        System.out.println(myList.toString()); // List before removing
        System.out.println(myList.remove(1)); // Prints true since 1 is removed
        System.out.println(myList.toString()); // New list after removing
        /* END OF PART 2 */
        
        /* PART 3 */
        System.out.println();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(3);
        arr1.add(5);
        arr1.add(6);
        arr1.add(6);
        arr1.add(7);
        arr1.add(8);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(5);
        arr2.add(6);
        arr2.add(6);
        arr2.add(6);
        arr2.add(9);
        
        ListSetOperations intersection = new ListSetOperations(arr1, arr2);
        List<Integer> arr3 = intersection.intersectionOfLists();
        System.out.println("Intersection of " + arr1 + " and " + arr2 + " is: ");
        System.out.println(arr3 + "\n");
        
        ArrayList<Integer> arr6 = new ArrayList<>();
        arr6.add(0);
        arr6.add(1);
        arr6.add(3);
        arr6.add(5);
        arr6.add(6);
        arr6.add(9);
        ArrayList<Integer> arr7 = new ArrayList<>();
        arr7.add(3);
        arr7.add(5);
        arr7.add(6);
        arr7.add(8);
        arr7.add(12);
        arr7.add(13);
        
        ListSetOperations union = new ListSetOperations(arr6, arr7);
        List<Integer> arr8 = union.unionOfLists();
        System.out.println("Union of " + arr6 + " and " + arr7 + " is: ");
        System.out.println(arr8 + "\n");
        
        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(0);
        arr4.add(1);
        arr4.add(3);
        arr4.add(5);
        arr4.add(6);
        arr4.add(6);
        ArrayList<Integer> arr5 = new ArrayList<>();
        arr5.add(3);
        arr5.add(5);
        arr5.add(6);
        arr5.add(6);
        
        ListSetOperations subset = new ListSetOperations(arr4, arr5);
        if(subset.isSubset()){
            System.out.println(arr5 + " is subset of " + arr4);
        }
        else{
            System.out.println(arr5 + " isn't subset of " + arr4);
        }
        
        System.out.println();
        
        /* END OF PART 3 */
        
        /* PART 1 */
        int numOfDisks = 4;
        Stack<Integer> src = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        Stack<Integer> dst = new Stack<>();
        
        // Push disks in the Source stack
        while(numOfDisks > 0){
            src.push(numOfDisks);
            --numOfDisks;
        }

        TowerOfHanoiSolver.TowerOfHanoi(src.size(), src, dst, aux);
        
        /* END OF PART 1 */
        
    }
}
