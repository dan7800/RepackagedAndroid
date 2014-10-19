package com.rit.AndroidAnalysisEngine.engine.impl;

import java.io.IOException;
import java.nio.file.Path;

import com.rit.AndroidAnalysisEngine.engine.ApkToJarConverter;

public class Dex2JarWrapper implements ApkToJarConverter{
	
	public String convertApkToJar(Path pathToApk, Path dirToCreateJar) {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
	    try {
			Process pr = rt.exec("../dex2jar/dex2jar.bat "+ pathToApk.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathToApk.toString();
	}
	
}
