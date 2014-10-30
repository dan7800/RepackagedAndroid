package com.rit.AndroidAnalysisEngine.engine;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.Activity;

public class SourceWriter {
	
	private Set<Class<? extends Activity>> activityClasses;
	
	public SourceWriter( Set<Class<? extends Activity>> activityClasses ){
		this.activityClasses = activityClasses;
	}
	
	public String getImportStrings(){
		String importLines= "";
		
		Iterator<Class<? extends Activity>> rator= activityClasses.iterator();
		importLines+="import android.os.Bundle;\n";
        while (rator.hasNext()){
        	importLines +="import "+rator.next().getName()+";\n";
        }
		
		return importLines;
	}
	
	public String getFunctionCalls(){
		String functionLines = "";
		Iterator<Class<? extends Activity>> rator= activityClasses.iterator();
		functionLines += "\t\tBundle bundle = new Bundle();\n";
		Class<? extends Activity> curAct;
        while (rator.hasNext()){
        	curAct = rator.next();
        	if (Modifier.isAbstract(curAct.getModifiers())){
        		continue;
        	}
        	functionLines += "\t\t" + curAct.getSimpleName() + " "+curAct.getSimpleName()+"Var = "+
        			"new "+curAct.getSimpleName()+"();\n";
        	functionLines += "\t\t" + curAct.getSimpleName()+"Var"+".onCreate(bundle);\n";
        }
		
		return functionLines;
	}
	
}
