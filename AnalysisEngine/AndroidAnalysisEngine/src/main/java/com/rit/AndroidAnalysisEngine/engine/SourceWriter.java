package com.rit.AndroidAnalysisEngine.engine;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.Activity;

public class SourceWriter {
	
	private Set<Class<? extends Activity>> activityClasses;
	
	private String importLines = "";
	private String functionLines = "";
	
	public SourceWriter( Set<Class<? extends Activity>> activityClasses ){
		this.activityClasses = activityClasses;
		
		Iterator<Class<? extends Activity>> rator= activityClasses.iterator();
		Class<? extends Activity> curAct;
        while (rator.hasNext()){
        	curAct = rator.next();
        	processActivity(curAct);
        }
	}
	
	private void processActivity(Class<? extends Activity> clazz){
		if(Modifier.isAbstract(clazz.getModifiers())){
			return;
		}
		generateImportStrings(clazz);
		generateFunctionCalls(clazz);
	}
	
	
	public void generateImportStrings(Class<? extends Activity> clazz){
		importLines +="import "+clazz.getName()+";\n";
	}
	
	public void generateFunctionCalls(Class<? extends Activity> clazz){
		functionLines += "\t\ttry{\n"; 
		functionLines += "\t\t\t" + clazz.getSimpleName() + " "+clazz.getSimpleName()+"Var = "+
        			"new "+clazz.getSimpleName()+"();\n";
        functionLines += "\t\t\t" + clazz.getSimpleName()+"Var"+".onCreate(null);\n";
        functionLines += "\t\t}catch(RuntimeException ex){\n\t\t\tSystem.out.println(\"Hit Runtime Exception!\");\n\t\t}\n"; 
	}

	public Set<Class<? extends Activity>> getActivityClasses() {
		return activityClasses;
	}

	public String getImportStrings() {
		return importLines;
	}

	public String getFunctionCalls() {
		return functionLines;
	}
	
	
	
}
