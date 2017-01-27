package com.mycompany.hw9_part2_131044084_mehmed_mustafa;

import java.io.*;

/** Abstract base class for graphs. A graph is a set
*   of vertices and a set of edges. Vertices are
*   represented by integers from 0 to n - 1. Edges
*   are ordered pairs of vertices.
*   @author Koffman and Wolfgang
*/

public abstract class AbstractGraph
    implements Graph {

  // Data Fields
  /** The number of vertices */
  private int numV;

  /** Flag to indicate whether this is a directed graph */
  private boolean directed;

  // Constructor
  /** Construct a graph with the specified number of vertices
      and the directed flag. If the directed flag is true,
      this is a directed graph.
      @param numV The number of vertices
      @param directed The directed flag
   */
  public AbstractGraph(int numV, boolean directed) {
    this.numV = numV;
    this.directed = directed;
    }

    // Accessor Methods
    /** Return the number of vertices.
      @return The number of vertices
    */
    @Override
    public int getNumV() {
    return numV;
    }

    /** Return whether this is a directed graph.
      @return true if this is a directed graph
    */
    @Override
    public boolean isDirected() {
    return directed;
    }

    // Other Methods
    /** Load the edges of a graph from the data in an input file.
      The file should contain a series of lines, each line
      with two or three data values. The first is the source,
      the second is the destination, and the optional third
      is the weight.
      @param bR The buffered reader containing the data
      @throws IOException if an I/O error occurs
    */
    public void loadEdgesFromFile(BufferedReader bR) throws IOException {
        int source = -2, dest = -3;
        double weight = -9999;
        int found, start, end;
        
        String lineFromFile = bR.readLine();
        if(!lineFromFile.contains("<Edges>")){
            System.out.println("WRONG INPUT TEXT FORMAT!");
            return;
        }
        
        while(true)
        {
          lineFromFile = bR.readLine();
          if(lineFromFile == null)
              break;
          if(lineFromFile.contains("<Edge"))
          {
            found = lineFromFile.indexOf("V1=\"v");
            start = found + 5;
            end = lineFromFile.indexOf("\"", start);
            if(found != -1 && end != -1)
                source = Integer.parseInt(lineFromFile.substring(start, end));
            
            found = lineFromFile.indexOf("V2=\"v");
            start = found + 5;
            end = lineFromFile.indexOf("\"", start);
            if(found != -1 && end != -1)
                dest = Integer.parseInt(lineFromFile.substring(start, end));
            
            found = lineFromFile.indexOf("Weight=\"");
            start = found + 8;
            end = lineFromFile.indexOf("\"", start);
            if(found != -1 && end != -1)
                weight = Double.parseDouble(lineFromFile.substring(start, end));
            
            this.insert(new Edge(source-1, dest-1, weight));
            
            /* Line for testing the readed data */
            //System.out.println("S: " + source + " " + "D: " + dest + " " + "W: " + weight);
          }
          if(lineFromFile.contains("</Edges>"))
              break;
        }
    }

    public static int findVinFile(BufferedReader bR) throws IOException{
      int numV = 0;

      while(true)
      {
        String lineFromFile = bR.readLine();
        if(lineFromFile == null)
            break;
        if(lineFromFile.contains("<Vertex"))
            ++numV;
        if(lineFromFile.contains("</Vertices>"))
            break;
      }

      return numV;
    }

    /** Factory method to create a graph and load the data from an input
      file. The first line of the input file should contain the number
      of vertices. The remaining lines should contain the edge data as
      described under loadEdgesFromFile.
      @param bR The BufferedReader that is connected to
                            the file that contains the data
      @param isDirected true if this is a directed graph,
                        false otherwise
      @param type The string "Matrix" if an adjacency matrix is to be
                  created, and the string "List" if an adjacency list
                  is to be created
      @return The created graph
      @throws IOException if there is an I/O error
      @throws IllegalArgumentException if type is neither "Matrix"
                                       nor "List"
    */
    public static Graph createGraph(BufferedReader bR,
                                  boolean isDirected,
                                  String type) throws IOException {
    int numV = findVinFile(bR);
    //System.out.println("Number of Vertecies: " + numV);
    AbstractGraph returnValue = null;
    if (type.equalsIgnoreCase("Matrix"))
      returnValue = new MatrixGraph(numV, isDirected);
    else if (type.equalsIgnoreCase("List"))
      returnValue = new ListGraph(numV, isDirected);
    else
      throw new IllegalArgumentException();
    returnValue.loadEdgesFromFile(bR);
    return returnValue;
    }
}
