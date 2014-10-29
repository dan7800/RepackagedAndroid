package com.rit.AndroidAnalysisEngine.engine;

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
        while (rator.hasNext()){
        	importLines +="import "+rator.next().getName()+";\n";
        }
		
		return importLines;
	}
	
}
