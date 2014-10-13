Tools
===

APK To Java
==

Usage 
=

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

Dependencies
=

* Java environment and python 2 or 3 on the local machine
