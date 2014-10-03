#!/bin/bash
echo "Starting test";
#TARGET_APP_1="./testapps/sample.apk";
TARGET_APP_2="./testapps/robodemo-sample-1.0.1.apk";
TARGET_APP_3="./testapps/coinpirates-real.apk";
TARGET_APP_4="./testapps/coinpirates-clone.apk";
ANDROID_SDK_PLATFORMS="/usr/local/android/android-sdk-linux/platforms";
OUTPUT_FILE_1="output/sample.out";
OUTPUT_FILE_2="output/robodemo-sample-1.0.1.out";
OUTPUT_FILE_3="output/coinpirates-real.out";
OUTPUT_FILE_4="output/coinpirates-clone.out";
#echo "Running command: run.sh "$TARGET_APP" "$ANDROID_SDK_PLATFORMS" "$OUTPUT_FILE;
#sh run.sh $TARGET_APP_1 $ANDROID_SDK_PLATFORMS $OUTPUT_FILE_1
echo "Running command: run.sh "$TARGET_APP_2" "$ANDROID_SDK_PLATFORMS" "$OUTPUT_FILE_2;
sh run.sh $TARGET_APP_2 $ANDROID_SDK_PLATFORMS $OUTPUT_FILE_2;
echo "Running command: run.sh "$TARGET_APP_3" "$ANDROID_SDK_PLATFORMS" "$OUTPUT_FILE_3;
sh run.sh $TARGET_APP_3 $ANDROID_SDK_PLATFORMS $OUTPUT_FILE_3;
echo "Running command: run.sh "$TARGET_APP_4" "$ANDROID_SDK_PLATFORMS" "$OUTPUT_FILE_4;
sh run.sh $TARGET_APP_4 $ANDROID_SDK_PLATFORMS $OUTPUT_FILE_4;