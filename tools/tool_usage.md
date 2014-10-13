#Tools

##Flowdroid Processor

Execute the FlowDroid taint anaysis tool on a batch of multiple apk files.
The output is then piped into a separate text file per APK, and stripped
for relevant information and source/sink combinations

### Usage


## APK To Java


### Usage


* Unpackage the flowdroid sub utility included in the apk to java directory
```
cd tools/apk_to_java
unzip dex2jar.zip
```

* Create an apks/ directory and move your APKs you would like to unpackage into this folder.
```
mkdir apks
mv /my/apks/* apks/
```
* run the apk to java.py program with no command line arguments
```
python apk_to_java.py
```
* The resulting JARs and classpath directories will be in the outputs/jars and outputs/claspaths directories, respectively

### Dependencies

* Java environment and python 2 or 3 on the local machine

### Testbed

* DroidBench - benchmark testing suite of apk files and java source directories
** Each file has a simple exploit introduced in oreder to test the effectiveness of malware analysis tools
