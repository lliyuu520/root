FROM registry.cn-chengdu.aliyuncs.com/lliyuu520/centos-java:0.02
# 备份及换源
LABEL "User"="lliyuu520"
ENV mysql_hostname mysql
ENV rabbitmq_hostname rabbitmq
ENV redis_hostname redis
ENV center_hostname center
ENV TZ Asia/Shanghai
COPY /target/*.jar /project/
CMD java -jar  /project/center.jar

