#apk_to_java.py
#Use tools to separate multiple apk files into separate java classpath directories

#Args: 
#$1 - Directory of APK files

import os
import sys
from subprocess import call

if (len(sys.argv) != 2):
	print("Usage: $1 - Directory of APK files")
	sys.exit()

apkDir = sys.argv[1]

#Take a directory of APK files and convert each APK to a jarfile
#Jars will be moved to outputs/jars/apkName.jar
def unpackAPKs():
	
	for filename in os.listdir(apkDir):
		if filename.endswith('.apk'):
			name = os.path.splitext(filename)[0]
			name = name.replace(" ", "-")

			os.rename(apkDir + '/' + filename, apkDir + '/' + name + '.apk')

			apkString = "apks/" + filename
			output = "-o outputs/" + name + ".jar"

			print("Processing APK file " + filename)
			call(["bash","dex2jar/d2j-dex2jar.sh",apkDir + "/" + filename,"-o", "outputs/jars/" + name + ".jar"])	

#Take any jarfiles in the outputs/jars directory and unpack 
#into their original classpath structure for processing. 
#classpaths moved to outputs/classpaths/jarName/<unpacked_contents>
def unpackJars():
	scriptPath = os.path.dirname(os.path.realpath(__file__))

	for jarfile in os.listdir('outputs/jars'):
		
		print("Processing jarfile " + jarfile )

		outputPath = scriptPath + "/outputs/classpaths/" + os.path.splitext(jarfile)[0]
		jarPath = scriptPath + '/outputs/jars/' + jarfile
		
		if not os.path.isdir(outputPath):
			os.makedirs(outputPath)
		
		os.chdir(outputPath)

		call(["jar","xf",jarPath])

unpackAPKs()
unpackJars()
