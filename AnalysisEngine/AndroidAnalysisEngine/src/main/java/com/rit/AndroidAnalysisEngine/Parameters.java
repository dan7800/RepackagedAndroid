package com.rit.AndroidAnalysisEngine;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class Parameters {
	 
	  @Parameter
	  private List<String> parameters = new ArrayList<String>();
	 
	  @Parameter(names = { "-apk" }, description = "Level of verbosity")
	  private String apkFileName;

}
