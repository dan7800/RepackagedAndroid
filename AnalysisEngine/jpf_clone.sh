#!/bin/bash
BASEDIR=$(dirname $0);
hg clone --verbose http://babelfish.arc.nasa.gov/hg/jpf/jpf-core $BASEDIR/jpf/jpf-core;
hg clone --verbose http://babelfish.arc.nasa.gov/hg/jpf/jpf-symbc $BASEDIR/jpf/jpf-symbc;