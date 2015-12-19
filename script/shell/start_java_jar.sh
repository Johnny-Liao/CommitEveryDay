#! /bin/bash

# program about
jarFileName=com.bj58.search.tools.jar    # your program name
jarCommands=offline.conf                 # runtime commands

# path
programPath=/home/work/liaoshihao		 # program path
logdir=/home/work/liaoshihao/log         # log path

# check program process
runcount=`ps -ef | grep "java -jar ${jarFileName} ${jarCommands}" | grep -v grep | wc -l`

if [ $runcount -lt 1 ] ; then
        echo `date` +":Warning ${jarFileName} is not runnning , start..........." >> ${logdir}/search_tools.log
        source /etc/profile
        cd $programPath
        nohup java -jar ${jarFileName} ${jarCommands} >> ${logdir}/pragram_runtime.log 2>&1 &
else
        echo `date` +"serch.tools is running : ok" >> ${logdir}/search_tools.log
fi

exit 1

# Timing start the script
# 00 4 * * * /bin/sh /home/work/liaoshihao/tools_start.sh > /home/work/liaoshihao/log/crontab.log 2>&1