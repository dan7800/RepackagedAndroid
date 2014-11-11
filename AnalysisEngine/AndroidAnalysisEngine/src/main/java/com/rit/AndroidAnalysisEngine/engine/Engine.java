package com.rit.AndroidAnalysisEngine.engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.rit.AndroidAnalysisEngine.engine.impl.Dex2JarWrapper;

public class Engine {
	
	public static File processApk(Path path){
		
		ApkToJarConverter converter = new Dex2JarWrapper();
		
		String jarToTarget  = converter.convertApkToJar(path, null);
	
        WrapperCompiler wrComp = new WrapperCompiler();
        File compiledJar = null;
        try {
        	compiledJar = wrComp.doCompile(99, new File(jarToTarget));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
}
