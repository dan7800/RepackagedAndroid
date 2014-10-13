#apk_to_java.py
#Use tools to separate multiple apk files into separate java classpath directories

import os
import sys
from subprocess import call

if not os.path.isdir('apks/'):
	print("Please create a directory named 'apks' with desired apk files to convert")
	sys.exit()

if not os.path.isdir('outputs/'):
	os.makedirs('outputs')
if not os.path.isdir('outputs/jars'):
	os.makedirs('outputs/jars/')
if not os.path.isdir('outputs/classpaths'):
	os.makedirs('outputs/classpaths/')

#Take a directory of APK files and convert each APK to a jarfile
#Jars will be moved to outputs/jars/apkName.jar
def unpackAPKs():
	for filename in os.listdir('apks/'):
		if filename.endswith('.apk'):
			name = os.path.splitext(filename)[0]
			name = name.replace(" ", "-")

			os.rename('apks/' + filename, 'apks/' + name + '.apk')

			apkString = "apks/" + filename
			output = "-o outputs/" + name + ".jar"

			print("Processing APK file " + filename)
			call(["bash","dex2jar/d2j-dex2jar.sh","apks/" + filename,"-o", "outputs/jars/" + name + ".jar"])	

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
