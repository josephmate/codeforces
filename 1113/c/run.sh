#!/usr/bin/env bash

javac Main.java
compileExitCode=$? 
if [ $compileExitCode -ne 0 ]
then
  echo "Compilation failed"
  exit $compileExitCode
fi

for i in `seq 1 3`
do
  echo actual: $(java Main < sample$i.txt)
  echo expected: $(cat expected$i.txt)
done
