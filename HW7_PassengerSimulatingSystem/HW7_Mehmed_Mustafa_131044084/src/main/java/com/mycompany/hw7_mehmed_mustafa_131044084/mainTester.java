package com.mycompany.hw7_mehmed_mustafa_131044084;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class mainTester{

    public static void main(String[] args){
        
        /* PART 1*/
        MehmedsSimulation mySimulation = new MehmedsSimulation();
        String inputFile = "data1.txt";
        String outputFile = "data1Log.txt";
        
        /* Start simulation with data1.txt */
        mySimulation.startSimulation(inputFile, outputFile);
        
        inputFile = "data2.txt";
        outputFile = "data2Log.txt";
        
        /* Start simulation with data2.txt */
        mySimulation.startSimulation(inputFile, outputFile);
         

        /* PART 2*/
        ArrayList<Integer> researcherID = new ArrayList<>();
        ArrayList<Integer> studentID = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        
        getRandomIDs(researcherID, studentID);
        
        for(int i=0; i<500; ++i)
            people.add(new Person(researcherID.get(i), studentID.get(i)));
        
        MehmeDChainHash<Integer, Person> hashedPeople = new MehmeDChainHash();
        
        for(int i=0; i<500; ++i)
            hashedPeople.put(people.get(i).hashCode(), people.get(i));
        
    }
    
    
    public static int randNum(int minNum, int maxNum){
        Random randomizer = new Random();
        int randNum = randomizer.nextInt((maxNum - minNum) + 1) + minNum;
        return randNum;
    }
    public static void getRandomIDs(ArrayList research, ArrayList student){
        int randomNumber;
        
        while(research.size() < 500){
            randomNumber = randNum(1000, 5000);
            
            if(!research.contains(randomNumber))
                research.add(randomNumber);
        }
        
        while(student.size() < 500){
            randomNumber = randNum(5001, 15000);
            
            if(!student.contains(randomNumber))
                student.add(randomNumber);
        }        
    }
    
    
}
