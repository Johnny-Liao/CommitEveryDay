#!/bin/sh
base_dir=$(cd `dirname $0`;pwd)
#echo ${base_dir}
find ${base_dir}/dir/ -mtime +3 -delete

