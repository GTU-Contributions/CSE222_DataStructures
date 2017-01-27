package com.mycompany.hw4_131044084_mehmed_mustafa;

import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.GeneralErrorException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.RegisterOverflowException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.SyntaxErrorException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class mainTester {
    public static void main(String [] args) 
            throws FileNotFoundException, 
                    IOException, RegisterOverflowException{
        InfixToPostfixConvertor toPostfixConvertor = new InfixToPostfixConvertor();
        postfixToAssemblyConvertor toAssemblyConvertor = new postfixToAssemblyConvertor();
        ArrayList<String> infixes = new ArrayList();
        ArrayList<String> postfixes = new ArrayList();
        ArrayList<String> assemblies = new ArrayList();
        
        BufferedReader infix = null;
        FileWriter postfix = null;
        FileWriter assembly = null;
        
        try 
        {
            infix = new BufferedReader(new FileReader("input1.txt"));
            postfix = new FileWriter("postfix1.txt");
            assembly = new FileWriter("output1.asm");
            
            try{
                
                /* Read infix from a file */
                String line = infix.readLine();
                
                while(line != null){
                    infixes.add(line + "\n");
                    line = infix.readLine();
                }
                /* End reading the infix from a file */
                
                /* Convert infix to postfix */
                for(String nextInfixExp : infixes){
                    postfixes.add(toPostfixConvertor.convert(nextInfixExp));
                }
                
                /* Write postfix to a file */
                for(String nextPostfixExp : postfixes){
                    postfix.write(nextPostfixExp);
                }

                /* Convert postfix to assembly */
                for(String nextPostfixExp : postfixes){
                    assemblies.add(toAssemblyConvertor.evalOneLine(nextPostfixExp));
                }
                
                /* Write assembly to a file */
                for(String nextAssemblyExp : assemblies){
                    assembly.write(nextAssemblyExp);
                }

                /* Prints infix, postfix and assembly on the console */
                for(String printNext : infixes){
                    System.out.print(printNext);
                }
                System.out.println();
                
                for(String printNext : postfixes){
                    System.out.print(printNext);
                }
                System.out.println();               
                
                for(String printNext : assemblies){
                    System.out.print(printNext);
                }
                System.out.println();
                

            }catch(SyntaxErrorException | GeneralErrorException error){
                System.out.println(error.getMessage());
            }                 
            
        }catch(FileNotFoundException error){
            System.out.println("Error: Input file is invalid!\n");
        }finally{
            if(infix!=null){
                infix.close();
            }
            if(postfix!=null){
                postfix.close();
            }
            if(assembly!=null){
                assembly.close();
            }
        }
        
    }
}
