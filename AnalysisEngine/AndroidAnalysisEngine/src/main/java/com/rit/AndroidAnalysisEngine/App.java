package com.rit.AndroidAnalysisEngine;

import java.io.IOException;

import com.beust.jcommander.JCommander;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	JCommander params = new JCommander(new Parameters(), args);
    	
        System.out.println( "Hello World!" );
        
    }
}
