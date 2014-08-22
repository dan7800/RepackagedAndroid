#!/bin/bash

#Usage: run.sh AppToTarget AndroidSDKPlatformsDirectory FileOutputName

#breakdown
#JAVA_ARGS= --Xmx3G
CLASSPATH="soot-trunk.jar:soot-infoflow.jar:soot-infoflow-android.jar:slf4j-api-1.7.5.jar:slf4j-simple-1.7.5.jar:axml-2.0.jar"
FLOWDROID="soot.jimple.infoflow.android.TestApps.Test"
TARGET_APP="$1"
ANDROID_SDK_PLATFORMS="$2"
OUTPUT_FILE="$3"
#finally, the command itself
java -cp $CLASSPATH $FLOWDROID $TARGET_APP $ANDROID_SDK_PLATFORMS > $OUTPUT_FILE