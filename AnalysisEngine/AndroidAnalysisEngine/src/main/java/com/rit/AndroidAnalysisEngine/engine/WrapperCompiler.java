package com.rit.AndroidAnalysisEngine.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WrapperCompiler {
	
	private final String indexToken = "{{INDEX}}";
	
	private String readFile(File src, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(src.getPath()));
			  return new String(encoded, encoding);
			}
	
	
	public void spawnFiles(int index) throws IOException{
		spawnWrapperFile(index);
		spawnManifestFile(index);
	}
	
	public void spawnManifestFile(int index) throws IOException{
		File sourceFile = new File("./spawn/manifest.mf.template");
		
		String rawSource = readFile(sourceFile, Charset.defaultCharset());
		String editedSource = rawSource.replace(indexToken, new Integer(index).toString());

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
	
	public File doCompile(int index) throws IOException {
		spawnFiles(index);
		//compile
        Runtime.getRuntime().exec("javac -g ./spawn/Wrapper"+index+".java > ./spawn/spawncompfail.txt");
        Runtime.getRuntime().exec("jar cmf ./spawn/manifest"+index+".mf ./spawn/Wrapper"+index+".jar ./spawn/Wrapper"+index+".class");
        //clean up
        cleanOutClassFiles();
        return new File("./spawn/Wrapper"+index+".jar");
	}
	
	public void cleanOutJarFiles() throws IOException{
		cleanOutFilesByPattern("*.jar");
	}
	
	private void cleanOutClassFiles() throws IOException{
		cleanOutFilesByPattern("*.class");
	}
	
	private void cleanOutFilesByPattern(String pattern) throws IOException{
		File dir = new File("./spawn");
        DirectoryStream<Path> stream = Files.newDirectoryStream(new File("./spawn").toPath(), pattern);
        File [] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");
            }
        });
        for (File file : files) {
            file.delete();
        }
	}
}
