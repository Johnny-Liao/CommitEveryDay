#! /bin/bash

# program about
jarFileName=***.jar    # your program name
jarCommands=***                 # runtime commands

# path
programPath=/**/**/johnny		 # program path
logdir=/**/**/johnny/log         # log path

# check program process
runcount=`ps -ef | grep "java -jar ${jarFileName} ${jarCommands}" | grep -v grep | wc -l`

if [ $runcount -lt 1 ] ; then
        echo `date` + " : Warning ${jarFileName} is not runnning , start..........." >> ${logdir}/start_pro.log
        source /etc/profile
        cd $programPath
        nohup java -jar ${jarFileName} ${jarCommands} >> ${logdir}/pragram_runtime.log 2>&1 &
else
        echo `date` +"serch.tools is running : ok" >> ${logdir}/start_pro.log
fi

exit 1

# Timing start the script at 4:00 am every day.
# 00 4 * * * /bin/sh /**/**/johnny/start_java_jar.sh > /**/**/johnny/log/crontab.log 2>&1