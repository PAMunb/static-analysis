#!/bin/sh

read -p "Where is a path directory that contains the projects? " dir

mvn clean

mvn package

python ClearOutput.py

python Cloc.py $dir

java -jar target/StaticAnalyser.jar "input.csv"

