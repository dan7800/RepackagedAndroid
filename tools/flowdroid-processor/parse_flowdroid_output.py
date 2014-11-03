#parse_flowdroid_output.py
#Parse the output files for the FlowDroid platform for 
#for any source to sink connections. 
import sys
import os

for textFile in os.listdir(sys.argv[1]):
	textFilePath = os.path.join(sys.argv[1], textFile)
	with open(textFilePath) as f:
		outputString = ''
		#print flow to sink connections in analysis
		for line in f:
			if 'Found a flow to sink' in line or '- ' in line:
				outputString = outputString + line

		file = open(textFilePath, 'a')
		file.write("\n\n\nCondensed report: \n" + outputString)
		file.close()

print("Completed output parsing and appended to bottom of original text files")
