Week 8
===


Week 7
===
To do for next week:
* Send status email for next weeks meeting on Monday, 10/20
* Precision, recall, accuracy. Evaluate 10 APKS with and without malware segments. Give exact specification of where malware was injected.
* Create a brief schedule for the rest of the term
* Tool to batch process and repackage android apps 
* Parser for tool output

Done from last week:
* APK Sample set using DroidBench
** Found DroidBench when doing concolic analysis using FlowDroid. Provides a test suite of android apps with exposed known malware in order to determine the effectiveness of taint analysis and other types of static analysis tools.
* Tool to unpackage and batch process APK files
** Tool is titled apk_to_java and contains a simple python script that uses dex2jar and jar xf commands to break down a set of APK files into classpaths and jarfiles, one of each per APK. 
* Automated use of flowdroid
** Still some work left to do in order to parse output of many flowdroid instances, but the ability to feed multiple APK files into FlowDroid is functional. 
* Documentation and code base cleanup

Week 6
===

SAC ACM Conference
Send Patrick information for creation of .java files for APK files (use of dex2jar)
Research Java pathfinder and fuzz frameworks for understandability


Find cases of false positives and specific cases of tools. EX: 
Our tool found X percentage of vulnerabilities as compared to this other set of tools. Begin working on this moving forward


Progress made:
Continued churning through the installation and documentation of tools
Uploaded functional tools to GitHub
Tools successfully installed:


   *      FlowDroid

   *      DroidScope 
   * 
      * Set up Ubuntu virtual disk image and spent some time attempting to compile the application based  on the wiki.    So far so good, but the app isn’t 100% functional at this point
      * Going through manual.pdf section for setup 

Question: Should I stick to tools that revolve around only static analysis, or should a broad spectrum of tools be tested (including dynamic analysis tools such as DroidScope)?


Week 5
===

Most of this week’s time was spent fighting to configure a working Android development environment, to get a simple set of Android applications running, and to set up a simple data bank of APKs for use in testing and development. A period of roughly three hours was spent installing all of the necessary SDKs for Android API versions 17-20, as well as getting all of the development tools up and running such as the Android virtual device manager, and the Android avd tool. Once a complete Android development environment complete with virtual devices and the ability to install third party applications was up and running, I began to get some of the most used taint and malware analysis tools up and running on my machine. This turned out to be a very tough and time consuming exercise, complete with wrestling dependencies and other various issues that came up with my environment. 

 So far here the collection of tools that I have running on my machine, complete with installation instructions: 

Hardware environment: 


   * Macbook Retina late 2013 model
   * 8GB RAM, Intel i5 2.4GHz processor
   * Mac OSX 10.10 ‘Yosemite’
   * 
      * Linux Mint 14 VirtualBox VM for use w/ the DroidScope tool 

Tools: 

FlowDroid


   * Description
   * 
      * Static taint analysis tool for all Android applications
      * GitHub

      * Project Description 

   * Dependencies
   * 
      * Completely Java based tool which creates a main method around the apk to trace through method calls. Requires the ‘platforms’ directory of a functional Android SDK environment, as well as the version of android that the APK file you are analyzing.
   * Installation
   * 
      * There is a link to the nightly build of each dependency of the application, which is packaged in its own .jar file. there are also four .txt files that are needed and regularly updated that are hosted in the same section of the GitHub read for the project. I created a simple bash script to execute all of the jarfiles with the -classpath argument, passing in the APK to preform taint analysis on, and the root directory of the platforms section of the Android SDK. 
      * Links to project dependencies and .txt files needed to run the tool:
      * 
         * Soot bundle (also contains Heros and Jasmin):http://ssebuild.cased.de/nightly/soot/lib/soot-trunk.jar
         * soot-infoflow: http://ssebuild.cased.de/nightly/soot-infoflow/build/jar/soot-infoflow.jar
         * soot-infoflow-android: http://ssebuild.cased.de/nightly/soot-infoflow-android/build/jar/soot-infoflow-android.jar
         * Libraries for Logging: https://github.com/secure-software-engineering/soot-infoflow-android/raw/develop/lib/slf4j-api-1.7.5.jar ANDhttps://github.com/secure-software-engineering/soot-infoflow-android/raw/develop/lib/slf4j-simple-1.7.5.jar
         * Android XML parser library: https://github.com/secure-software-engineering/soot-infoflow-android/raw/develop/lib/axml-2.0.jar
         * Source and sink text file

         * Taint wrapper config file

         * Callbacks config file

      * A sample directory has been included

DroidScope


   * Description
   * 
      * Dynamic binary analysis tool for android applications. Given complete with its own VirtualBox image to make it easier to configure



Week 4
===


Accomplished Tasks:
Week four was spent mainly working alongside Professor Krutz putting together a proof of concept document that verified the ability to detect malware snippets through concolic analysis of Android applications. A small write up was done by both patrick and myself to outline the process we used in order to get results from the JCute and Java Pathfinder concolic analysis tools to outline the insertion of a malicious method call into a previously benign application. 

From here, work will be spent attempting to get some malware detection tools functioning on our local development environment and then generating a sample set of infected and benign APKs that can be used for further testing. 

A small biography was also written up by myself and Patrick to put a list of our contributions up on the darwin.rit.edu site. 

Proof of concept and bio writeup

For next week, I will be spending time getting at least three tools up and running with a small sample set of APK files, and attempting to get tangible results when injecting my own malware samples into benign apk files and running them through various malware detection tools. 


Week 3
===


Since this is the first time I will be marking down information in a progress log for the Semester, I’m going to spend some time doing a quick overview of the things that I have already researched and accomplished. 

I spent a majority of my time over these past couple weeks researching the different generalized techniques of detecting repackaged android applications in third party app stores. Since I did not know much on the subject on Android development, I set up a quick environment to be able to open, compile, and execute any unpackaged android applications that I could find lying around the web. After getting a development environment straightened out, I spent some time looking for general publications that proposed solutions for manually determining if malicious code had been repackaged into an android app. This each led me to a piece of software named APKtool [https://code.google.com/p/android-apktool/]. This application can break down .apk files, exposing some configuration and source code of applications. Malicious code then can be injected into the application, and it can be re packaged using the same tool. It looks like this specific tool is not used as often as some others, but it could prove useful in research. 

Fortunately since the problem of trying to unpackage .apk files into .java source code had been addressed by a previous research team under Dr Krutz, I have been working towards using a package of scripts that were written for a previous research project to decompile android applications in our dev environment. Once this is up and running, I should be able to execute any repackaging techniques that I find in various publications. This leads me to where I am at this point in the project. 

I have collected a decent deal of information on several techniques that can be used to detect repackaged Android applications. All of this information can be found here: Repackaged Android Tools - Research Notes

Now that I am up to see with what I’ve been up to the past couple of weeks, here are the tasks that I have been working on for my third week of the project:


   * Looking into fuzzy hashing techniques
   * Actually getting APK to Java tool functional on our environment (shell scripts are functional on local dev machine for now)
   * Created a brief presentation of the ‘latest and greatest’ Android repackaging techniques
   * Spending some time getting familiar with FlowDroid, a concolic analysis tool. Trying to see if this tool has any use in detecting repackaged android applications.
   * Finding examples of repackaged android malware 

Fuzzy Hashing (Reference)


   * Used to determine if two pieces of Malware are similar
   * Cryptographic hashing - generating a hash based on a chunk of data that can be verified against other hashes to determine if two data pieces are the same. 
   * 
      * This is often inefficient because even a single bit being changed in the data payload will alter the composition of the hash.
   * Many different types of fuzzy hashing
   * 
      * Recent post popular fuzzy hashing tool - ssdeep (used for a method called context triggered piecewise hashing)
      * Many different fuzzy hashing techniques exist and can be employed on byte code, source code files, and basically any piece of data
   * Overall, the technique of fuzzy hashing is less precise that more literal hashing techniques, but it can be very useful to determine similarities in known malware samples. 

FlowDroid


   * Taint analysis tool for android applications
   * Simple taint checking overview - Grab any variables or data points that can potentially be impacted by a user’s input. The system will warn a user if any variable or data point in this chain is being used to execute a potentially malicious command (SQL statement, OS level code execution, I/O, etc…) 
   * This tool certainly could be useful in determining repackaged applications. 
   * 
      * Publication in 2014 outlining a new tool Apposcopy which uses static taint analysis in order to determine if an app has been repackaged: Found Here (http://www.apposcopy.com/)
      * This publication uses a combination of taint analysis and static evaluation of malware signatures

Repackaged Android Malware Example


   * Found an example of flappy bird apk with an SMS trojan built in. Comparing this with the standard v1.3 apk of flappy bird
   * 
      * the AndroidManifests.xml file for the trojan application contains request for full superuser access to the device saying it is used to encrypt information. 
      * Permissions are set much lower in the Android Manifests of the actual application
   * Setting up an emulation environment to execute both APK files to see how well hidden the exploit is since the applications have a very different structure when decompiled.
