#!/bin/bash

#Usage: run.sh AppToTarget AndroidSDKPlatformsDirectory FileOutputName

#breakdown
#JAVA_ARGS= --Xmx3G
echo "Setting vars:"
CLASSPATH="soot-trunk.jar:soot-infoflow.jar:soot-infoflow-android.jar:slf4j-api-1.7.5.jar:slf4j-simple-1.7.5.jar:axml-2.0.jar"
echo "CLASSPATH = "$CLASSPATH
FLOWDROID="soot.jimple.infoflow.android.TestApps.Test"
echo "FLOWDROID = "$FLOWDROID
TARGET_APP="$1"
echo "TARGET_APP = "$TARGET_APP
ANDROID_SDK_PLATFORMS="$2"
echo "ANDROID_SDK_PLATFORMS = "$ANDROID_SDK_PLATFORMS
OUTPUT_FILE="$3"
echo "OUTPUT_FILE = "$OUTPUT_FILE
#finally, the command itself
echo "Command: java -cp "$CLASSPATH" "$FLOWDROID" "$TARGET_APP" "$ANDROID_SDK_PLATFORMS" > "$OUTPUT_FILE
echo "Running!"
java -cp $CLASSPATH $FLOWDROID $TARGET_APP $ANDROID_SDK_PLATFORMS > $OUTPUT_FILE