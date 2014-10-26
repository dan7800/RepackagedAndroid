#parse_flowdroid_output.py
#Parse the output files for the FlowDroid platform for 
#for any source to sink connections. 
import sys

with open(sys.argv[1]) as f:
   #print flow to sink connections in analysis
   for line in f:
   		if 'Found a flow to sink' in line or '- ' in line:
   			print line
