package com.mycompany.hw1_131044084_mehmed_mustafa;
import java.util.Calendar;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Homework extends Assignment{
    
    /**
     * Default constructor
     */
    public Homework(){
        this.setName("NoHomeworkName");
        this.setDeadLine(null);
        this.setLateDeadLine(null);
        
    }
    /**
     * 
     * @param hwName name of the homework
     * @param deadLine dead line of the homework
     * @param lateDeadLine late dead line of the homework
     */
    public Homework(String hwName, Calendar deadLine, Calendar lateDeadLine){
        this.setName(hwName);
        this.setDeadLine(deadLine);
        this.setLateDeadLine(lateDeadLine);
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        String temp = "Homework: " + getName() + ", dead line: " + getDeadLine();
        temp += ", late dead line: " + getLateDeadLine();
        return temp;
    }
}
