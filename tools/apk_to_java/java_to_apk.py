#apk_to_java.py
#Use tools to separate multiple apk files into separate java classpath directories

import os
import sys
from subprocess import call

def packClasspathToApk():
	
	dirname = sys.argv[1]
	outputJar = sys.argv[2]
	
	#convert specified directory to a jarfile
	call(["jar","cf", outputJar + '.jar', dirname])
	
	#Convert jarfile to a .dex equivalent
	call(['bash', 'dex2jar/d2j-jar2dex.sh', '-f', outputJar])
	
	#Convert .dex files back to APK format
	call(['zip', '-r', outputJar + '.apk', outputJar + '-jar2dex.dex' ])

	#Cleanup unused dex and jar formats. Leave us with a nice APK <3
	call(['rm', outputJar + '-jar2dex.dex' ])
	call(['rm', outputJar + '.jar' ])

packClasspathToApk()
