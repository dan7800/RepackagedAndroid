#!/bin/bash

rm -rf ./jpf/*;
mkdir -p ./jpf/jpf-core/;
mkdir -p ./jpf/jpf-symbc/;
hg clone --verbose http://babelfish.arc.nasa.gov/hg/jpf/jpf-core ./jpf/jpf-core/;
hg clone --verbose http://babelfish.arc.nasa.gov/hg/jpf/jpf-symbc ./jpf/jpf-symbc/;

cd ./jpf/jpf-core/;
ant;
cd ../../jpf/jpf-symbc/;
ant;