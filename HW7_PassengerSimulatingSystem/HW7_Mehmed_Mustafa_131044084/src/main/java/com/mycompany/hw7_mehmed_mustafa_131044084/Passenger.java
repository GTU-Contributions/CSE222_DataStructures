package com.mycompany.hw7_mehmed_mustafa_131044084;

/**
 * Passenger class to track the passengers information
 * @author Mehmed Mustafa 131044084
 */
public class Passenger implements Comparable{
    
    //Data Fields
    /* Time that passengers arrive */
    private final Timer arrivalTime;
    /* Time to serve a passenger in minutes */
    private final int serviceTime;
    /* Type of the customer 1 gold, 2 silver, 3 bronze */
    private final int customerType;
    
    // Constructor
    public Passenger(Timer arrivalTime, int serviceTime, int type){
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.customerType = type;
    }
    
    //Setters and getters
    /**
     * Arrival time getter 
     * @return Get the passenger's arrival time
     */
    public Timer getArrivalTime(){
        return arrivalTime;
    }
    
    /**
     * Service time getter
     * @return Get the service time
     */
    public int getServiceTime(){
        return serviceTime;
    }
    
    /**
     * Customer type getter
     * @return Get the customer type
     */
    public int getCustomerType(){
        return customerType;
    }
    
    /**
     * 
     * @param o Object to be compared to
     * @return Positive value if the current customer type is bigger than otherTime
     *         Negative value if the current customer type is smaller than otherTime
     *         Zero value if the the customer types are equal
     */
    @Override
    public int compareTo(Object o) {
        Passenger otherPassenger;
        
        if(o instanceof Passenger)
            otherPassenger = (Passenger)o;
        else
            return -99;
        
        if(this.customerType > otherPassenger.customerType)
            return 1;
        else if(this.customerType < otherPassenger.customerType)
            return -1;
        else
            return 0;
    }

    /**
     * 
     * @return String format of the passenger
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Arrival Time: ");
        result.append(arrivalTime);
        result.append(" Service Time: ");
        result.append(serviceTime);
        result.append(" Customer Type: ");
        
        switch(customerType){
            case 1: result.append("Gold"); break;
            case 2: result.append("Silver"); break;
            case 3: result.append("Bronze"); break;
        }
        
        return result.toString();
    }
}








