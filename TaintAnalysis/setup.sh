rm *.jar
rm *.txt
wget http://ssebuild.cased.de/nightly/soot/lib/soot-trunk.jar
wget http://ssebuild.cased.de/nightly/soot-infoflow/build/jar/soot-infoflow.jar
wget http://ssebuild.cased.de/nightly/soot-infoflow-android/build/jar/soot-infoflow-android.jar
wget --no-check-certificate https://github.com/secure-software-engineering/soot-infoflow-android/raw/develop/lib/slf4j-simple-1.7.5.jar
wget --no-check-certificate https://github.com/secure-software-engineering/soot-infoflow-android/raw/develop/lib/axml-2.0.jar
wget http://ssebuild.cased.de/nightly/soot-infoflow-android/SourcesAndSinks.txt
wget http://ssebuild.cased.de/nightly/soot-infoflow/EasyTaintWrapperSource.txt
wget http://ssebuild.cased.de/nightly/soot-infoflow-android/AndroidCallbacks.txt