#!/bin/bash
CURDIR=$(pwd);
BASEDIR=$(dirname $0);
cd $BASEDIR/jpf/jpf-core;
ant;
cd $BASEDIR/jpf/jpf-symbc; 
ant;
cd $CURDIR;