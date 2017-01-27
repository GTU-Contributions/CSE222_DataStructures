package com.mycompany.hw9_part2_131044084_mehmed_mustafa;

import java.util.*;

/** A MatrixGraph is an implementation of the Graph
*   abstract class that uses an array to represent the
*   edges.
*   @author Mehmed Mustafa
*/

public class MatrixGraph
    extends AbstractGraph {
    
    // Data Field
    private double[][] edges;    

    /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
    */
    public MatrixGraph(int numV, boolean directed) {
      super(numV, directed);
      edges = new double[numV][];
      if (!directed) {
        for (int i = 0; i != numV; ++i) {
            edges[i] = new double[numV];
            for (int j = 0; j != numV; ++j) {
                edges[i][j] = Double.POSITIVE_INFINITY;
          }
        }
      }
      else {
        for (int i = 0; i != numV; ++i) {
            edges[i] = new double[i + 1];
            for (int j = 0; j != i + 1; ++j) {
                edges[i][j] = Double.POSITIVE_INFINITY;
          }
        }
      }
    }
    
    /** Method to set the value of an edge
    @param source - The source vertix
    @param dest - The destination vertix
    @param wt - The weight
    */
    private void setEdgeValue(int source, int dest, double wt) {
      if (isDirected() || source <= dest) {
        edges[source][dest] = wt;
      }
      else {
        edges[dest][source] = wt;
      }
    }

    /** Method to get the value of an edge
     *  @param source - The source vertix
     *  @param dest - The destination vertix
     *  @return The weight of this edge or
     *  POSITIVE_INFINITY if no edge exists
     */
    private double getEdgeValue(int source, int dest) {
      if (isDirected() | source <= dest) {
        return edges[source][dest];
      }
      else {
        return edges[dest][source];
      }
    }

    /** Determine if an edge exists
        @param source - The source vertix
        @param dest - The destination vertix
        @return true if there is an edge from source to dest
    */
    @Override
    public boolean isEdge(int source, int dest) {
        if(source < 0 || source >= this.getNumV())
            return false;
        if(dest < 0 || dest >= this.getNumV())
            return false;
        
        if(edges[source][dest] != Double.POSITIVE_INFINITY)
            return true;
        
        return false;
    }
    
    /** Insert a new edge into the graph
        @param edge - The new edge
    */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()][edge.getDest()] = edge.getWeight();
        
        if (!isDirected()) {
          edges[edge.getDest()][edge.getSource()] = edge.getWeight();
        }
    }

    /** Get the edge between two vertices.
        @param source - The source
        @param dest - The destination
        @return the edge between these two vertices
     */    
    @Override
    public Edge getEdge(int source, int dest) {
        if(isEdge(source, dest))
            return new Edge(source, dest, edges[source][dest]);
        
        /* Target not found, return edge with infinity weight */
        return new Edge(source, dest, Double.POSITIVE_INFINITY);
    }

    /** Return an iterator to the edges connected
        to a given vertix.
        @param source - The source vertix
        @return an EdgeIterator to the vertices
        contcted to source
    */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return new Iter(source);
    }
    
    // Iter class
    /** An iterator to the edges.  An Edge iterator is
     *  similar to an Iterator except that its
     *  next method will always return an edge
     */
    private class Iter
        implements Iterator < Edge > {
      // Data fields
      /** The source vertix for this iterator */
      private final int source;

      /** The current index for this iterator */
      private int index;

      // Constructor
      /** Construct an EdgeIterator for a given vertix
       *  @param source - The source vertix
       */
      public Iter(int source) {
        this.source = source;
        index = -1;
        advanceIndex();
      }

      /** Return true if there are more edges
       *  @return true if there are more edges
       */
      @Override
      public boolean hasNext() {
        return index != getNumV();
      }

      /** Return the next edge if there is one
       *  @throws NoSuchElementException - there are no
       *  more edges
       *  @return the next Edge in the iteration
       */
      @Override
      public Edge next() {
        if (index == getNumV()) {
          throw new java.util.NoSuchElementException();
        }
        Edge returnValue = new Edge(source, index,
                                    getEdgeValue(source, index));
        advanceIndex();
        return returnValue;
      }

      /** Remove is not implememted
       *  @throws UnsupportedOperationExeption if called
       */
      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }

      /** Advance the index to the next edge */
      private void advanceIndex() {
        do {
          index++;
        }
        while (index != getNumV()
               && Double.POSITIVE_INFINITY == getEdgeValue(source, index));
      }
    }
    
}
