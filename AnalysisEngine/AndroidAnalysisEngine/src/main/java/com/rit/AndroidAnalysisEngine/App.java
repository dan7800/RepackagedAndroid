package com.rit.AndroidAnalysisEngine;

import java.io.File;

import com.beust.jcommander.JCommander;
import com.rit.AndroidAnalysisEngine.engine.Engine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Parameters params = new Parameters();
    	JCommander jc = new JCommander(params, args);
    	
        System.out.println( "Hello World!" );
        
        File targetApk = new File(params.getApkFileName());
        if(!targetApk.exists()){
        	System.out.println("No such APK.");
        }
        Engine.processApk(targetApk.toPath());
        
        
    }
}
