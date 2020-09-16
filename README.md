# Seata

1. 注册中心 nacos

启动nacos ` $ .\startUp.cmd -m standalone`  单体本地8848端口启动nacos<br />访问http://localhost:8848/nacos 账号:nacos 密码:nacos

2. 配置TC端,配置文件 [config.txt](https://github.com/seata/seata/blob/develop/script/config-center/config.txt)
```
# 此处需要跟client端一致
service.vgroupMapping.seata-account-service-group=default
service.vgroupMapping.seata-stock-service-group=default
service.vgroupMapping.seata-order-service-group=default
```
启动 [nacos-config.sh](https://github.com/seata/seata/blob/develop/script/config-center/nacos/nacos-config.sh),将配置文件注册到配置中心,观察输出

3. 配置TM端,Seata registry.conf,file.conf 文件,选择nacos+redis 启动seate

``$ .\startUp.bat -m redis`  

4. client端部署,参考项目 [https://github.com/lliyuu520/root](https://github.com/lliyuu520/root)

