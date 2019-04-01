#!/bin/bash 

javac *.java

if [ -z "$2" ]
	then
		echo "You must provide a path"
		exit
fi

java TP3 -e $2
