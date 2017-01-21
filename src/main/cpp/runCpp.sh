#!/usr/bin/env bash

[[ $# != 1 ]] && {
    echo Please pass the source code.
    exit 1
} 

pro_name=${1%.*}
g++ $1 -o $pro_name 

echo -e "Start run.....\n"
./$pro_name
echo -e "\nDone."

rm $pro_name
