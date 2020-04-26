#! /bin/bash
#注意：必须有&让其后台执行，否则没有pid生成   jar包路径为绝对路径
nohop java -jar E:\\zmd\\dmp\\center\\target\\center.jar > E:\\zmd\\dmp\\log\\center\\center.log &

# 将jar包启动对应的pid写入文件中，为停止时提供pid
echo $! > E:\\zmd\\dmp\\log\\center\PID.txt