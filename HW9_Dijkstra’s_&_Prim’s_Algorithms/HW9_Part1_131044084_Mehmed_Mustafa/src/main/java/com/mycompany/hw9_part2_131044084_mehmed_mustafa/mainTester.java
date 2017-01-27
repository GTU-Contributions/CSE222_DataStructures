package com.mycompany.hw9_part2_131044084_mehmed_mustafa;

import java.io.*;
import java.util.*;

/**     
 *
 * @author mmustafa
 */
public class mainTester{
    
    public static void main(String[] argv){
        ArrayList<String> inputFiles = new ArrayList<>();
        ArrayList<Graph> listGraphs = new ArrayList<>();
        ArrayList<Graph> matrixGraphs = new ArrayList<>();
        addFiles(inputFiles);
        
        /* Print the name of the files in the folder */
        System.out.println("---- LOADED FILES ----");
        Iterator<String> fileIter = inputFiles.iterator();
        while (fileIter.hasNext()){
            System.out.println(fileIter.next());
        }
        System.out.println("----------------------------------");
        
        createGraphsFromFiles(inputFiles, listGraphs, matrixGraphs);
        int start = 1;
        int[] pred = new int[1000];
        double[] dist = new double[1000];
        System.out.println("----------------------------------");
        System.out.println("DIJKSTRAS ALGORITHM TIME ANALYSIS");
        /* Time algorithm analysis for listGraphs */
        System.out.println("LISTGRAPHS IMPLEMENTATION");
        for(int i = 0; i<inputFiles.size(); ++i){
            System.out.println(inputFiles.get(i));
            getDijkstrasAlgorithmTime(listGraphs.get(i), start, pred, dist);
        }
        System.out.println("----------------------------------------");
        /* Time algorithm analysis for matrixGraphs */
        System.out.println("MATRIXGRAPHS IMPLEMENTATION");
        for(int i = 0; i<inputFiles.size(); ++i){
            System.out.println(inputFiles.get(i));
            getDijkstrasAlgorithmTime(matrixGraphs.get(i), start, pred, dist);
        }
        System.out.println("--------------END--------------------");
        
        System.out.println("----------------------------------");
        System.out.println("PRIMS ALGORITHM TIME ANALYSIS");
        /* Time algorithm analysis for listGraphs */
        System.out.println("LISTGRAPHS IMPLEMENTATION");
        for(int i = 0; i<inputFiles.size(); ++i){
            System.out.println(inputFiles.get(i));
            getPrimsAlgorithmTime(listGraphs.get(i), start);
        }
        System.out.println("----------------------------------------");
        /* Time algorithm analysis for matrixGraphs */
        System.out.println("MATRIXGRAPHS IMPLEMENTATION");
        for(int i = 0; i<inputFiles.size(); ++i){
            System.out.println(inputFiles.get(i));
            getPrimsAlgorithmTime(matrixGraphs.get(i), start);
        }
        System.out.println("--------------END--------------------");
    }
    
    public static void addFiles(ArrayList<String> inputFiles){
        /* Vertices: 10 and Sparsity: 0.2 to 0.80 */
        inputFiles.add("HW9_Graphs/ver10sp02.xml");
        inputFiles.add("HW9_Graphs/ver10sp05.xml");
        inputFiles.add("HW9_Graphs/ver10sp075.xml");
        inputFiles.add("HW9_Graphs/ver10sp080.xml");
        
        /* Vertices: 50 and Sparsity: 0.2 to 0.80 */
        inputFiles.add("HW9_Graphs/ver50sp02.xml");
        inputFiles.add("HW9_Graphs/ver50sp05.xml");
        inputFiles.add("HW9_Graphs/ver50sp075.xml");
        inputFiles.add("HW9_Graphs/ver50sp080.xml");
        
        /* Vertices: 100 and Sparsity: 0.2 to 0.80 */
        inputFiles.add("HW9_Graphs/ver100sp02.xml");
        inputFiles.add("HW9_Graphs/ver100sp05.xml");
        inputFiles.add("HW9_Graphs/ver100sp075.xml");
        inputFiles.add("HW9_Graphs/ver100sp080.xml");        
        
        /* Vertices: 500 and Sparsity: 0.2 to 0.80 */
        inputFiles.add("HW9_Graphs/ver500sp02.xml");
        inputFiles.add("HW9_Graphs/ver500sp05.xml");
        inputFiles.add("HW9_Graphs/ver500sp075.xml");
        inputFiles.add("HW9_Graphs/ver500sp080.xml");
        
        /* Vertices: 1000 and Sparsity: 0.2 to 0.80 */
        inputFiles.add("HW9_Graphs/ver1000sp02.xml");
        inputFiles.add("HW9_Graphs/ver1000sp05.xml");
        inputFiles.add("HW9_Graphs/ver1000sp075.xml");
        inputFiles.add("HW9_Graphs/ver1000sp080.xml");
    }
    
    public static void createGraphsFromFiles(ArrayList<String> inputFiles, 
        ArrayList<Graph> listGraphs, ArrayList<Graph> matrixGraphs){
        int filesInFolder = inputFiles.size();
        BufferedReader input = null;
        try
        {
            /* Create graphs from the files using List implementation */
            for(int i = 0; i<filesInFolder; ++i)
            {
                input = new BufferedReader(new FileReader(inputFiles.get(i)));
                listGraphs.add(AbstractGraph.createGraph(input, false, "List"));
            }
            System.out.println("----- LIST graphs created!   -----");
            
            /* Create graphs from the files using Matrix implementation */
            for(int i = 0; i<filesInFolder; ++i)
            {
                input = new BufferedReader(new FileReader(inputFiles.get(i)));
                matrixGraphs.add(AbstractGraph.createGraph(input, false, "Matrix"));
            }
            System.out.println("----- MATRIX graphs created! -----");
            
            
        }catch(FileNotFoundException error){
            System.out.println("Error1: " + error.getMessage());
        }catch(IOException error){
            System.out.println("Error2: " + error.getMessage());
        }finally{
            if(input != null)
                try {
                    input.close();
            }catch(IOException error) {
                System.out.println("Error3: " + error.getMessage());
            }
        }
        
    }
    
    public static void getDijkstrasAlgorithmTime(Graph theGraph, int start, 
        int[] pred, double[] dist){
        long tStart, tEnd;
        tStart = System.nanoTime();
        DijkstrasAlgorithm.dijkstrasAlgorithm(theGraph, start, pred, dist);
        tEnd = System.nanoTime();
        System.out.println("Gecen zaman: " + (tEnd-tStart)/1000 + " mikroSeconds");
        
    }
    
    public static void getPrimsAlgorithmTime(Graph theGraph, int start){
        long tStart, tEnd;
        tStart = System.nanoTime();
        PrimsAlgorithm.primsAlgorithm(theGraph, start);
        tEnd = System.nanoTime();
        System.out.println("Gecen zaman: " + (tEnd-tStart)/1000 + " mikroSeconds");        
    }
}
