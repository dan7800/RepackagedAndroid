#run.py
#usage - run.py <apkName> 

import os
import sys

jarfiles = 'soot-trunk.jar:soot-infoflow.jar:soot-infoflow-android.jar:slf4j-api-1.7.5.jar:slf4j-simple-1.7.5.jar:axml-2.0.jar soot.jimple.infoflow.android.TestApps.Test'
platformsDir = "/Users/justinpeterson/Android/android-sdk-macosx/platforms"

apkFile = sys.argv[1]
apkFilename = os.path.basename(apkFile)
apkFiletxt = 'output/' + os.path.splitext(apkFilename)[0] + '.txt'

file = open(apkFiletxt, 'w')
file.close()	

os.system('java -cp ' + jarfiles + ' "' + apkFile + '" ' + platformsDir + '> ' + apkFiletxt)
