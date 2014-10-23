package com.rit.AndroidAnalysisEngine.engine;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WrapperCompilerUnitTest {

	private WrapperCompiler wrapperCompiler = new WrapperCompiler();
	private final int testIndex = 99;
	private final String jarPath = "./spawn/Wrapper"+testIndex+".jar";
	
	
	
	@Before
	public void setUp(){
		wrapperCompiler = new WrapperCompiler();
		File jar = new File(jarPath);
		if(jar.exists()){
			jar.delete();
		}
	}
	
	@Test //only checks existence of jar
	public void basicCompile() throws Exception{
		wrapperCompiler = new WrapperCompiler();
		wrapperCompiler.doCompile(99);
		File jar = new File(jarPath);
		if(jar.exists()){
			//jar.delete();
			return;
		}
		fail();
	}
	
	
}
