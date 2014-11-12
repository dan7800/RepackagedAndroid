package com.rit.AndroidAnalysisEngine.engine;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.common.io.CharStreams;
import com.rit.AndroidAnalysisEngine.Config;

public class JpfRunner {

	public String runAgainstFile(File file) throws IOException{
		
		String jpfDir = Config.getConfig().getJpfPath();
		String command = "sh "+jpfDir+"bin/jpf spawn/"+file.getName();
		//String command = "echo hello > /Users/McAfee/test.out.txt";
		Process runProc = Runtime.getRuntime().exec(command);
		try {
			runProc.waitFor(); //what could go wrong? Oh, right, infinite hang . . .
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		(new File("./results/")).mkdirs();
		String resultsFile = "./results/"+file.getName()+".jpfout.txt";
		PrintWriter outToFile = new PrintWriter(resultsFile);
		outToFile.print(CharStreams.toString(new InputStreamReader(runProc.getInputStream(), "UTF-8")));
		outToFile.close();
		return resultsFile; 
	}
	
	
	
	
}
