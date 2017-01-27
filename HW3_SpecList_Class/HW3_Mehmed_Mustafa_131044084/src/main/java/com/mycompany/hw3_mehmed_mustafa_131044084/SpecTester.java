/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw3_mehmed_mustafa_131044084;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mehmed Mustafa 131044084
 * Tester for the SpecList class
 */
public class SpecTester {
    public static void main(String[] args){
        SpecList<Integer> myIntList = new SpecList<>();
        LinkedList<Integer> yourIntList = new LinkedList<>();
        
        yourIntList.add(1);
        yourIntList.add(4);
        yourIntList.add(6);
        yourIntList.add(3);
        yourIntList.add(13);
        yourIntList.add(6);
        yourIntList.add(8);
        
        myIntList.add(1);
        myIntList.add(4);
        myIntList.add(5);
        myIntList.add(6);
        myIntList.add(3);
        myIntList.add(6);
        myIntList.add(2);
        myIntList.add(13);
        
        SpecList<Integer> IntegerIntersec = (SpecList) myIntList.getIntersectList(yourIntList);

        System.out.println("First Integer set is: " + yourIntList);
        System.out.println("Second Integer set is: " + myIntList);
        System.out.println("First + Second intersection is: " + IntegerIntersec);
        System.out.println("Sorted second Integer set from lower to bigger is: " + myIntList.sortList());
        System.out.println("First + Second sorted intersection is: " + IntegerIntersec.sortList());
        
        ArrayList<Integer> hisIntList = new ArrayList<>();
        
        hisIntList.add(77);
        hisIntList.add(66);
        hisIntList.add(44);
        hisIntList.add(55);
        hisIntList.add(33);
        
        System.out.println("Third Integer set is: " + hisIntList);
        
        // Try-catch check
        myIntList.addAllAtHead(null);
        myIntList.getIntersectList(null);
        
        myIntList.addAllAtHead(hisIntList);
        System.out.println("Second + Third Integer set combination is: " + myIntList);
        System.out.print("Second + Third Integer set sorted from bigger to lower is: ");
        System.out.println(myIntList.sortList(1));
        System.out.println();
        
        SpecList<Double> myDoubleList = new SpecList<>();
        ArrayList<Double> yourDoubleList = new ArrayList<>();

        yourDoubleList.add(1.5);
        yourDoubleList.add(2.7);
        yourDoubleList.add(4.55);
        yourDoubleList.add(12.17);
        yourDoubleList.add(3.99);
        yourDoubleList.add(3.77);
        yourDoubleList.add(1.5);
        
        myDoubleList.add(3.7);
        myDoubleList.add(2.14);
        myDoubleList.add(3.99);
        myDoubleList.add(4.55);
        myDoubleList.add(1.5);
        
        SpecList<Double> DoubleIntersec = (SpecList) myDoubleList.getIntersectList(yourDoubleList);
        
        System.out.println("First Double set is: " + yourDoubleList);
        System.out.println("Second Double set is: " + myDoubleList);
        System.out.println("First + Second intersection is: " + DoubleIntersec);
        System.out.println("Sorted second double set from bigger to lower is: " + myDoubleList.sortList(1));
        System.out.println("First + Second sorted intersection is: " + DoubleIntersec.sortList());
        System.out.println();
        
        
        SpecList<Character> myCharList = new SpecList<>();
        ArrayList<Character> yourCharList = new ArrayList<>();

        yourCharList.add('z');
        yourCharList.add('a');
        yourCharList.add('w');
        yourCharList.add('y');
        yourCharList.add('b');
        yourCharList.add('b');
        yourCharList.add('k');
        yourCharList.add('s');
        
        myCharList.add('o');
        myCharList.add('t');
        myCharList.add('m');
        myCharList.add('b');
        myCharList.add('c');
        myCharList.add('x');
        myCharList.add('w');
        myCharList.add('b');
        myCharList.add('a');
        myCharList.add('z');
        
        SpecList<Character> CharIntersec = (SpecList) myCharList.getIntersectList(yourCharList);
        
        System.out.println("First Character set is: " + yourCharList);
        System.out.println("Second Character set is: " + myCharList);
        System.out.println("First + Second intersection is: " + CharIntersec);
        System.out.println("Sorted second character set from lower to bigger is: " + myCharList.sortList());
        System.out.println("First + Second sorted intersection is: " + CharIntersec.sortList());
        System.out.println();        
        
    }
}
