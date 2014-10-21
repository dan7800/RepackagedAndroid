package com.rit.AndroidAnalysisEngine.engine;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class WrapperCompiler {
	
	public void spawnWrapperFile(){
		//TODO stub
	}
	
	public String doCompile(int index) throws IOException {
		//TODO compile
        Runtime.getRuntime().exec("javac -g ./spawn/Wrapper.java");
        Runtime.getRuntime().exec("jar cmf ./spawn/manifest.mf ./spawn/Wrapper"+index+".jar ./spawn/Wrapper.class");
        //clean up
        cleanOutClassFiles();
        return "Wrapper"+index;
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
