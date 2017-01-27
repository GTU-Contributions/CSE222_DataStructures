/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw9_part2_131044084_mehmed_mustafa;

/**
 *
 * @author mmustafa
 */
public class Edge{
    
    // Data Fields
    /** The source vertix */
    private int source;
    /** The destination vertix */
    private int dest;
    /** The weight */
    private double weight;
    
    // Constructor
    /** Construct an Edge with a source of from
        and a destination of to. Set the weight
        to 1.0.
        @param source - The source vertix
        @param dest - The destination vertix
     */
    public Edge(int source, int dest){
        this.source = source;
        this.dest = dest;
        weight = 1.0;
    }
    
    /** Construct a weighted edge with a source
        of from and a destination of to. Set the
        weight to w.
        @param source - The source vertix
        @param dest - The destination vertix
        @param w - The weight
     */    
    public Edge(int source, int dest, double w){
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }
    
    // Methods
    /** Get the source
        @return The value of source
     */
    public int getSource() {return source;}

    /** Get the destination
        @return The value of dest
     */
    public int getDest() {return dest;}

    /** Get the weight
        @return the value of weight
     */
    public double getWeight() {return weight;}

    /** Return a String representation of the edge
        @return A String representation of the edge
    */
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Destination: ");
        string.append(dest);
        string.append(", Source: ");
        string.append(source);
        
        return string.toString();
    }

    /** Return true if two edges are equal.
        @param o The object to compare to
        @return true if the edges have the same source
        and destination
    */
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || !(o instanceof Edge))
            return false;
        
        Edge other = (Edge)o;
        if((this.source == other.source) &&
            (this.dest == other.dest))
            return true;
        
        return false;
    }

    /** Return a hash code for an edge.
        @return a hash code for an edge
    */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.dest;
        hash = 97 * hash + this.source;
        return hash;
    }
    
}
