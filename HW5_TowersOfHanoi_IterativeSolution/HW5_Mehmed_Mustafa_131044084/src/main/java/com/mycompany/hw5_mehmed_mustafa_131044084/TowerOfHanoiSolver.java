package com.mycompany.hw5_mehmed_mustafa_131044084;
import java.util.Stack;

/**
 * Solves tower of hanoi problem iteratively
 * @author Mehmed Mustafa 131044084
 */
public class TowerOfHanoiSolver {
    
    /**
     * Method to solve the hanoi problem
     * @param disksize The number of disks
     * @param src Source Stack
     * @param dst Destination Stack
     * @param aux Auxiliary Stack
     */
    public static void TowerOfHanoi(int disksize, Stack<Integer> src, 
                                 Stack<Integer> dst, Stack<Integer> aux){
        if(disksize <= 0 || src == null || dst == null || aux == null)
            return;
        
        /* Find the minimum needed moves: 2^disksize - 1 */
        int minimumNeededMoves = 1;
        for(int i=0; i<disksize; ++i)
            minimumNeededMoves *=2;
        --minimumNeededMoves;    
        
        if(disksize%2==1){
            System.out.println("Start!");
            System.out.println("Source: " + src);
            System.out.println("Auxiliary: " + aux);
            System.out.println("Destination: " + dst);
            System.out.println();
            for(int i=1; i <= minimumNeededMoves; ++i){

                // Move disk from Source to Destination
                if(i%3==1)
                    moveDisk(src, dst);

                // Move disk from Source to Auxiliary
                if(i%3==2)
                    moveDisk(src, aux);

                // Move disk from Auxiliary to Destination
                if(i%3==0)
                    moveDisk(aux, dst);

                System.out.println("Move #" + i);            
                System.out.println("Source: " + src);
                System.out.println("Auxiliary: " + aux);
                System.out.println("Destination: " + dst);
                System.out.println();
            }
        }else{
            System.out.println("Start!");
            System.out.println("Source: " + src);
            System.out.println("Auxiliary: " + aux);
            System.out.println("Destination: " + dst);
            System.out.println();
            for(int i=1; i <= minimumNeededMoves; ++i){

                // Move disk from Source to Auxiliary
                if(i%3==1)
                    moveDisk(src, aux);

                // Move disk from Source to Destination
                if(i%3==2)
                    moveDisk(src, dst);

                // Move disk from Destination to Auxiliary
                if(i%3==0)
                    moveDisk(dst, aux);

                System.out.println("Move #" + i);            
                System.out.println("Source: " + src);
                System.out.println("Auxiliary: " + aux);
                System.out.println("Destination: " + dst);
                System.out.println();
            }
        }
    }
    
    /**
     * Moves one disk from source to destination
     * @param src Source
     * @param dst Destination
     */
    protected static void moveDisk(Stack<Integer> src, Stack<Integer> dst){
        if(src.isEmpty()) // Source is empty
            src.push(dst.pop()); // Push from destination to source
        else if(dst.isEmpty()) // Destination is empty
            dst.push(src.pop()); // Push from source to destination
        else if(src.peek() > dst.peek()) // Source's top disk is bigger than destination's
            src.push(dst.pop()); // Push from destination to source
        else if(src.peek() < dst.peek()) // Destination's top disk is bigget than source's
            dst.push(src.pop()); // Push from source to destination
    }

}
