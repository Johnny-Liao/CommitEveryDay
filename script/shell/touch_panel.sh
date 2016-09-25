#!/usr/bin/env bash

sudo su <<EOF
modprobe -r psmouse
modprobe psmouse proto=imps
EOF
echo 'Open the touch panel.'
