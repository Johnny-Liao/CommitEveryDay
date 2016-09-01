#!/bin/sh

sh compile.sh

source /etc/profile

# rm -rf exe_result

echo `date "+%Y-%m-%d %H:%M:%S"`" status:running" >> coder_info

# java MainFrame > exe_result 2>&1
java -Xms8g -Xmx8g -Xmn4g MainFrame > exe_result 2>&1

