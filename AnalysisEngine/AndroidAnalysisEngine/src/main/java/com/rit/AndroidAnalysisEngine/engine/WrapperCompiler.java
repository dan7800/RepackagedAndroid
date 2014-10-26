package com.rit.AndroidAnalysisEngine.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

@SuppressWarnings("restriction") //compiler dependency
public class WrapperCompiler {
	
	private final String indexToken = "{{INDEX}}";
	
	private String readFile(File src, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(src.getPath()));
			  return new String(encoded, encoding);
			}
	
	
	public void spawnFiles(int index, File targetJar) throws IOException{
		spawnWrapperFile(index);
		spawnManifestFile(index, targetJar);
	}
	
	private String getClassPathString(Path targetJarPath) throws IOException{
		String classpath = "";
		File dir = new File("./lib/");
        File [] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        for (File file : files) {
            classpath+="."+file.getPath().toString()+":"; // hacky
        }
		return classpath+targetJarPath.toString();
	}
	
	public void spawnManifestFile(int index, File targetJar) throws IOException{
		File sourceFile = new File("./spawn/manifest.mf.template");
		
		String rawSource = readFile(sourceFile, Charset.defaultCharset());
		String editedSource = rawSource.replace(indexToken, new Integer(index).toString());
		editedSource = editedSource.replace("{{CLASSPATH}}", getClassPathString(targetJar.toPath()));

		PrintWriter outToFile = new PrintWriter("./spawn/manifest"+index+".mf");
		outToFile.println(editedSource);
		outToFile.close();
	}
	
	public void spawnWrapperFile(int index) throws IOException{
		File sourceFile = new File("./spawn/Wrapper.template");
		
		String rawSource = readFile(sourceFile, Charset.defaultCharset());
		String editedSource = rawSource.replace(indexToken, new Integer(index).toString());

		//TODO crazy stuff here
		PrintWriter outToFile = new PrintWriter("./spawn/Wrapper"+index+".java");
		outToFile.println(editedSource);
		outToFile.close();
		
	}
	
	public File doCompile(int index, File targetJar) throws IOException{
		spawnFiles(index, targetJar);
			
		//compile
		
		Process compileProc = Runtime.getRuntime().exec("javac -classpath ./lib/* ./spawn/Wrapper"+index+".java");
		try {
			compileProc.waitFor(); //what could go wrong? Oh, right, infinite hang . . .
		} catch (InterruptedException e) {
			//HERESY WILL BE SUPPRESSED
			e.printStackTrace();
		} 
		
		//make the damn jar
		Process jarProc =  Runtime.getRuntime().exec("jar cmf ./spawn/manifest"+index+".mf ./spawn/Wrapper"+index+".jar ./spawn/Wrapper"+index+".class");
        
		try {
			jarProc.waitFor(); //what could go wrong? Oh, right, infinite hang . . .
		} catch (InterruptedException e) {
			//HERESY WILL BE SUPP - wait, didn't I already yell this?
			e.printStackTrace();
		} 
		//clean up
        cleanOutClassFiles();
        return new File("./spawn/Wrapper"+index+".jar");
        /*WARNING: if you got major.minor versions, I feel bad for you son
        			I got 99 problems, but too many JDKs ain't one 
        Real Answer: get your default user JDK and JRE in sync.  No really. 
        	The inanity of how I'm doing this (who uses exec?) means I can't control 
        	which java is on your path.*/
	}
	
	public void cleanOutJarFiles() throws IOException{
		cleanOutFilesByPattern("*.jar");
	}
	
	private void cleanOutClassFiles() throws IOException{
		cleanOutFilesByPattern("*.class");
	}
	
	private void cleanOutFilesByPattern(String pattern) throws IOException{
		File dir = new File("./spawn");
        File [] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });
        for (File file : files) {
            file.delete();
        }
	}
}
