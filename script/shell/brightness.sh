#!/usr/bin/env bash

if [ $# != 1 ];
then
    exit -1
fi

sudo su <<EOF
echo $1 > /sys/class/backlight/intel_backlight/brightness
echo "change the brightness to $1"
EOF
