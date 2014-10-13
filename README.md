General setup:

1) Setup the VM
  a) Install Vagrant
  b) Go to the root directoroty of the repo (where this file is)
  c) Run "vagrant up" and wait for the machine to come online
  d) Run "vagrant ssh" to enter the virtual machine
2) All included projects will be in "~/Workspace/" in the VM

Analysis Engine Setup:

1) In the VM, navigate to "~/Workspace/AnalysisEngine"
  a) Set up JPF
    i) run jpf_clone.sh - this pulls down the repositories
	ii) run jpf_build.sh - this builds the required jars
  b) ??? - project setup to be determined