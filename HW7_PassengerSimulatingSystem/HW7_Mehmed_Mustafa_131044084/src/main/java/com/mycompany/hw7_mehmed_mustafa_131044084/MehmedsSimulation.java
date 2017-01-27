package com.mycompany.hw7_mehmed_mustafa_131044084;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Simulation class
 * @author Mehmed Mustafa 131044084
 */
public class MehmedsSimulation{
    
    //Data Fields
    /* The passengers priority queue */
    private final MehmedsPriorityQueue<Passenger> passengers;
    /* The passengers readed from the input file */
    private final ArrayList<Passenger> fileInputPassengers;
    /* Counter for Gold passengers */
    private int totalGold;
    /* Counter for Silver passengers */
    private int totalSilver;
    /* Counter for Bronze passengers */
    private int totalBronze;
    
    /**
     * Default Constructor
     */
    public MehmedsSimulation(){
        passengers = new MehmedsPriorityQueue<>();
        fileInputPassengers = new ArrayList<>();
        totalGold = 0;
        totalSilver = 0;
        totalBronze = 0;
    }
    
    /**
     * Method to start simulation process
     * @param inputFileName Input file name
     * @param outputFileName Log file name
     */
    public void startSimulation(String inputFileName, String outputFileName){
        FileWriter output = null;
        try {
            output = new FileWriter(outputFileName);
            
            output.write("Arrival Time\t Leaving Time\t Customer Type\n");
            
            Timer leavingTimeOfCurr = new Timer();
            Timer currSimTimer, endSimCountTimer;
            Passenger currPassenger;
            
            /* Read passengers from the text file */
            readPassengers(inputFileName, fileInputPassengers);
            passengers.offer(fileInputPassengers.remove(0));
            //Set the starting simulation time to the first persons arrival time
            currSimTimer = passengers.peek().getArrivalTime();
            //Add 20 hours(1200 minutes) to find when to stop counting Gold, Silver and Bronze
            endSimCountTimer = currSimTimer.increaseMinutes(1200);
            
            while(true)
            {
                // Look at the queue
                if(passengers.peek() != null) //If the queue isn't empty
                {
                    currPassenger = passengers.poll(); //Get the first passenger
                    currSimTimer.addMinutes(currPassenger.getServiceTime()); //Calculate leaving time
                    leavingTimeOfCurr = currSimTimer;
                    output.write(currPassenger.getArrivalTime().toString());
                    output.write("\t\t\t " + leavingTimeOfCurr + "\t\t\t Customer " + currPassenger.getCustomerType() + "\n");
                    System.out.print(currPassenger.getArrivalTime().toString());
                    System.out.println("\t\t\t " + leavingTimeOfCurr + "\t\t\t Customer " + currPassenger.getCustomerType());
                    
                    if(currSimTimer.compareTo(endSimCountTimer) > 0)
                    {
                        switch(currPassenger.getCustomerType())
                        {
                            case 1: ++totalGold; break;
                            case 2: ++totalSilver; break;
                            case 3: ++totalBronze; break;     
                        }
                    }
                }

                while(!fileInputPassengers.isEmpty() && 
                fileInputPassengers.get(0).getArrivalTime().compareTo(leavingTimeOfCurr) < 0)
                {
                    passengers.offer(fileInputPassengers.remove(0));
                }
                
                if(passengers.isEmpty() && !fileInputPassengers.isEmpty())
                {
                    passengers.offer(fileInputPassengers.remove(0));
                    currSimTimer = passengers.peek().getArrivalTime();
                }
                
                if(fileInputPassengers.isEmpty() && passengers.isEmpty())
                    break;     
            }
            
            output.write("Customers served for the last 20 hours:\n");
            output.write("Gold status: " + totalGold + "\n");
            output.write("Silver status: " + totalSilver + "\n");
            output.write("Bronze status: " + totalBronze + "\n");
            int totalCustomers = totalGold + totalSilver + totalBronze;
            output.write("Total served customers: " + totalCustomers + "\n");
            System.out.println("Customers server for the last 20 hours:");
            System.out.println("Gold status: " + totalGold);
            System.out.println("Silver status: " + totalSilver);
            System.out.println("Bronze status: " + totalBronze);
            System.out.println("Total served customers: " + totalCustomers + "\n");
            
        }catch (IOException error){
            System.out.println("Error: " + error.getMessage());
        }finally{
            if(output != null)
                try {
                    output.close();
            }catch(IOException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
    
    /**
     * Method to read all the passengers from the input file
     * @param inputFileName The name of the input file
     * @param passengers Passengers are read to this array
     */
    private void readPassengers(String inputFileName, ArrayList<Passenger> passengers){     
        BufferedReader input = null;
        
        /* Read all passengers info from the text file */
        try
        {
            input = new BufferedReader(new FileReader(inputFileName));
            String line = input.readLine(); // Jump the first line of the file
            int hour, minute, serviceTime, type;
            
            /* Read data from the input file */
            while((line = input.readLine()) != null)
            {
                hour = Integer.parseInt(line.substring(0, 2));
                minute = Integer.parseInt(line.substring(3, 5));
                serviceTime = Integer.parseInt(line.substring(16, 18));
                type = Integer.parseInt(line.substring(41, 42));
                passengers.add(new Passenger(new Timer(hour, minute), serviceTime, type));
            }
        }catch(FileNotFoundException error){
            System.out.println("Error: " + error.getMessage());
        }catch(IOException error) {
                System.out.println("Error: " + error.getMessage());
        }finally{
            if(input != null)
                try {
                    input.close();
            }catch(IOException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
    
    
}
