package com.rit.AndroidAnalysisEngine.engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.rit.AndroidAnalysisEngine.engine.impl.Dex2JarWrapper;

public class Engine {

	public static File processApk(String path){
		
		return processApk(FileSystems.getDefault().getPath(path));
	}
	
	public static File processApk(Path path){
		
		ApkToJarConverter converter = new Dex2JarWrapper();
		
		converter.convertApkToJar(path, null);
	
		return null;
	}
	
}
