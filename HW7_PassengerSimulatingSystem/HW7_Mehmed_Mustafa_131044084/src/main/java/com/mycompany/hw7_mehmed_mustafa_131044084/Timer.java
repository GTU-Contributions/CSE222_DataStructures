package com.mycompany.hw7_mehmed_mustafa_131044084;

/**
 * Timer class to check time of the simulation
 * @author Mehmed Mustafa 131044084
 */

public class Timer{
    //Data Fields
    /* Hours of the timer */
    private int hour;
    /* Minutes of the timer */
    private int minute;
    
    // Constructors
    
    /**
     * Default constructor
     */
    public Timer(){
        hour = 0;
        minute = 0;
    }
    
    /**
     * Constructor with 2 parameters
     * @param hour Set the clock hours to hour
     * @param minute Set the clock minutes to minute
     */
    public Timer(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    // Setters and Getters
    /**
     * Hours setter
     * @param hour Set the clock hours to hour 
     */
    public void setHour(int hour){
        this.hour = hour;
    }
    
    /**
     * Minutes setter
     * @param minute Set the clock minutes to minute 
     */
    public void setMinute(int minute){
        this.minute = minute;
    }
    
    /**
     * Hours getter
     * @return Get the clock hours
     */
    public int getHour(){
        return hour;
    }
    
    /**
     * Minutes getter
     * @return Get the clock minutes
     */
    public int getMinute(){
        return minute;
    }
    
    /**
     * Timer getter
     * @return Get the clock hours and minutes
     */
    public Timer getTime(){
        return new Timer(this.hour, this.minute);
    }
    
    /**
     * Add minutes to the current time without changing current time
     * @param minutes Add minutes with value minutes to the timer clock
     * @return Get the clock hours and minutes after increment
     */
    public Timer increaseMinutes(int minutes){
        int totalMinutes = 60*hour + minute;
        totalMinutes += minutes;
        
        if(totalMinutes > 1440)
            totalMinutes %= 1440;
        
        int hourS = totalMinutes/60;
        int minuteS = totalMinutes%60;
        
        return new Timer(hourS, minuteS);
    }
    
    /**
     * Add minutes to the current time
     * @param minutes Add minutes with value minutes to the timer clock
     */
    public void addMinutes(int minutes){
        int totalMinutes = 60*hour + minute;
        totalMinutes += minutes;
        
        if(totalMinutes > 1440)
            totalMinutes %= 1440;
        
        hour = totalMinutes/60;
        minute = totalMinutes%60;            
    }
    
    /**
     * Comparing method
     * @param otherTime Time to compare current time
     * @return Positive value if the current time is bigger than otherTime
     *         Negative value if the current time is smaller than otherTime
     *         Zero value if the the timers are equal
     */
    public int compareTo(Timer otherTime){
        if(this.hour > otherTime.hour)
            return 1;
        else if(this.hour < otherTime.hour)
            return -1;
        else // Hours are equal
        {
            if(this.minute > otherTime.minute)
                return 1;
            else if(this.minute < otherTime.minute)
                return -1;
            else // Minutes are equal
                return 0;
        }
    }
    
    /**
     * 
     * @return String format of the timer
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(hour < 10){
            result.append(0);
            result.append(hour);
        }
        else
            result.append(hour);
        
        result.append(':');
        
        if(minute < 10){
            result.append(0);
            result.append(minute);
        }
        else
            result.append(minute);
        
        return result.toString();
    }
}
