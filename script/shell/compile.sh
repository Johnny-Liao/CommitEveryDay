#!/bin/sh

rm *.class -rf

files=""
for file in *.java; do
  files=$files' '$file
done

javac -verbose $files > compile_result 2>&1
