#! /bin/bash
PID=$(cat /web/pid.txt)
kill -9 $PID